package com.isagiongo.pragmabrewery.unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.isagiongo.pragmabrewery.controller.dto.BeerValidationDTO;
import com.isagiongo.pragmabrewery.validator.BeerValidator;
import com.isagiongo.pragmabrewery.validator.LagerValidator;

public class LagerValidatorTest {

	private BeerValidator beerValidator;
	private BeerValidationDTO beerValidationDTO;

	@Before
	public void setUp() {
		beerValidationDTO = new BeerValidationDTO();
		beerValidator = new LagerValidator();
	}

	@Test
	public void shouldValidateIfTemperatureIsValidForLager() {
		beerValidationDTO.setTemperature(-4.0);
		assertTrue(beerValidator.isValidTemperature(beerValidationDTO));
	}

	@Test
	public void shouldValidateIfTemperatureIsLessThanMinimumForLager() {
		beerValidationDTO.setTemperature(-7.1);
		assertFalse(beerValidator.isValidTemperature(beerValidationDTO));
	}

	@Test
	public void shouldValidateIfTemperatureIsGreaterThanMaximumForLager() {
		beerValidationDTO.setTemperature(-3.9);
		assertFalse(beerValidator.isValidTemperature(beerValidationDTO));
	}
}