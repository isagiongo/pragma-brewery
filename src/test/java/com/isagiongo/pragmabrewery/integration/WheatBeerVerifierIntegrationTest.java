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
public class WheatBeerVerifierIntegrationTest {

	@LocalServerPort
	private int randomPort;

	@Before
	public void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = randomPort;
	}

	@Test
	public void shouldValidateIfTemperatureIsNull() {
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"temperature\": \"\"}")
				.post("/v1/beers/{beerName}/validations", "WheatBeer")
				.then()
				.statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	public void shouldValidateIfTemperatureIsValidForWheatBeer() {
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"temperature\": -4}")
				.post("/v1/beers/{beerName}/validations", "WheatBeer")
				.then()
				.body("message", Matchers.equalTo("Temperature OK"))
				.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void shouldValidateIfTemperatureIsLessThanMinimumForWheatBeer() {
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"temperature\": -6}")
				.post("/v1/beers/{beerName}/validations", "WheatBeer")
				.then()
				.body("message", Matchers.equalTo("Inappropriate Temperature"))
				.statusCode(HttpStatus.EXPECTATION_FAILED.value());
	}
	
	@Test
	public void shouldValidateIfTemperatureIsGreaterThanMaximumForWheatBeer() {
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"temperature\": -2}")
				.post("/v1/beers/{beerName}/validations", "WheatBeer")
				.then()
				.body("message", Matchers.equalTo("Inappropriate Temperature"))
				.statusCode(HttpStatus.EXPECTATION_FAILED.value());
	}
}
