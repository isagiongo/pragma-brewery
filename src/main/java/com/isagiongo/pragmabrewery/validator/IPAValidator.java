package com.isagiongo.pragmabrewery.validator;

import org.springframework.stereotype.Component;

import com.isagiongo.pragmabrewery.controller.dto.BeerValidationDTO;

@Component
public class IPAValidator implements BeerValidator {
	
	private static final Double MAX_TEMPERATURE = -5.0;
	private static final Double MIN_TEMPERATURE = -6.0;

	@Override
	public Boolean isValidTemperature(BeerValidationDTO beerValidationDTO) {
		return beerValidationDTO.getTemperature() >= MIN_TEMPERATURE && beerValidationDTO.getTemperature() <= MAX_TEMPERATURE;
	}
}
