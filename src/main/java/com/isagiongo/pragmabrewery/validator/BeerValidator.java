package com.isagiongo.pragmabrewery.validator;

import com.isagiongo.pragmabrewery.controller.dto.BeerValidationDTO;

public interface BeerValidator {
	
	Boolean isValidTemperature(BeerValidationDTO beerValidationDTO);

}
