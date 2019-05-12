package com.isagiongo.pragmabrewery.unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.isagiongo.pragmabrewery.controller.dto.BeerValidationDTO;
import com.isagiongo.pragmabrewery.validator.BeerValidator;
import com.isagiongo.pragmabrewery.validator.IPAValidator;

public class IPAValidatorTest {

	private BeerValidator beerValidator;
	private BeerValidationDTO beerValidationDTO;

	@Before
	public void setUp() {
		beerValidationDTO = new BeerValidationDTO();
		beerValidator = new IPAValidator();
	}

	@Test
	public void shouldValidateIfTemperatureIsValidForIPA() {
		beerValidationDTO.setTemperature(-5.0);
		assertTrue(beerValidator.isValidTemperature(beerValidationDTO));
	}

	@Test
	public void shouldValidateIfTemperatureIsLessThanMinimumForIPA() {
		beerValidationDTO.setTemperature(-6.1);
		assertFalse(beerValidator.isValidTemperature(beerValidationDTO));
	}

	@Test
	public void shouldValidateIfTemperatureIsGreaterThanMaximumForIPA() {
		beerValidationDTO.setTemperature(-4.9);
		assertFalse(beerValidator.isValidTemperature(beerValidationDTO));
	}
}