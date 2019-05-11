package com.isagiongo.pragmabrewery.validator;

import org.springframework.stereotype.Component;

import com.isagiongo.pragmabrewery.controller.dto.BeerValidationDTO;

@Component
public class PilsnerValidator {
	
	private static final int MAX_TEMPERATURE = -4;
	private static final int MIN_TEMPERATURE = -6;

	public Boolean isValidTemperature(BeerValidationDTO beerValidationDTO) {
		return beerValidationDTO.getTemperature() > MIN_TEMPERATURE && beerValidationDTO.getTemperature() < MAX_TEMPERATURE;
	}
}
