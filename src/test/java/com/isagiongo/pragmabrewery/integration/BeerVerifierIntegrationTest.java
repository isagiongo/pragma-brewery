package com.isagiongo.pragmabrewery.integration;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BeerVerifierIntegrationTest {

	@LocalServerPort
	private int randomPort;

	@Before
	public void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = randomPort;
	}

	@Test
	public void shouldValidateValidTemperatureForPilsner() {
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"temperature\": -5}")
				.post("/v1/beers/{beerName}/validations", "Pilsner")
				.then()
				.body("message", Matchers.equalTo("Temperature OK"))
				.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void shouldValidateLowerTemperatureThenMinimumForPilsner() {
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"temperature\": -7}")
				.post("/v1/beers/{beerName}/validations", "Pilsner")
				.then()
				.body("message", Matchers.equalTo("Invalid Temperature"))
				.statusCode(HttpStatus.EXPECTATION_FAILED.value());
	}
	
	@Test
	public void shouldValidateHigherTemperatureThenMaximumForPilsner() {
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"temperature\": -2}")
				.post("/v1/beers/{beerName}/validations", "Pilsner")
				.then()
				.body("message", Matchers.equalTo("Invalid Temperature"))
				.statusCode(HttpStatus.EXPECTATION_FAILED.value());
	}

}
