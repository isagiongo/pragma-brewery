package com.isagiongo.pragmabrewery.unit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.isagiongo.pragmabrewery.controller.dto.BeerValidationDTO;
import com.isagiongo.pragmabrewery.validator.BeerValidator;
import com.isagiongo.pragmabrewery.validator.PilsnerValidator;

public class PilsnerValidatorTest {

	private BeerValidator beerValidator;
	private BeerValidationDTO beerValidationDTO;

	@Before
	public void setUp() {
		beerValidationDTO = new BeerValidationDTO();
		beerValidator = new PilsnerValidator();
	}

	@Test
	public void shouldValidateIfTemperatureIsValidForPilsner() {
		beerValidationDTO.setTemperature(-6.0);
		assertTrue(beerValidator.isValidTemperature(beerValidationDTO));
	}

	@Test
	public void shouldValidateIfTemperatureIsLessThanMinimumForPilsner() {
		beerValidationDTO.setTemperature(-6.1);
		assertFalse(beerValidator.isValidTemperature(beerValidationDTO));
	}

	@Test
	public void shouldValidateIfTemperatureIsGreaterThanMaximumForPilsner() {
		beerValidationDTO.setTemperature(-3.9);
		assertFalse(beerValidator.isValidTemperature(beerValidationDTO));
	}
}
