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
public class LagerVerifierIntegrationTest {

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
				.post("/v1/beers/{beerName}/validations", "Lager")
				.then()
				.statusCode(HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void shouldValidateIfTemperatureIsValidForLager() {
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"temperature\": -4}")
				.post("/v1/beers/{beerName}/validations", "Lager")
				.then()
				.body("message", Matchers.equalTo("Temperature OK"))
				.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void shouldValidateIfTemperatureIsLessThanMinimumForLager() {
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"temperature\": -8}")
				.post("/v1/beers/{beerName}/validations", "Lager")
				.then()
				.body("message", Matchers.equalTo("Inappropriate Temperature"))
				.statusCode(HttpStatus.EXPECTATION_FAILED.value());
	}
	
	@Test
	public void shouldValidateIfTemperatureIsGreaterThanMaximumForLager() {
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"temperature\": -3}")
				.post("/v1/beers/{beerName}/validations", "Lager")
				.then()
				.body("message", Matchers.equalTo("Inappropriate Temperature"))
				.statusCode(HttpStatus.EXPECTATION_FAILED.value());
	}
	
	@Test
	public void shouldValidateIfBeerNameIsValid() {
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"temperature\": -4}")
				.post("/v1/beers/{beerName}/validations", "ISA")
				.then()
				.body("message", Matchers.equalTo("Invalid Beer"))
				.statusCode(HttpStatus.BAD_REQUEST.value());
	}
}