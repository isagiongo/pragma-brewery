package com.isagiongo.pragmabrewery.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isagiongo.pragmabrewery.controller.dto.BeerValidationDTO;
import com.isagiongo.pragmabrewery.controller.dto.ResultValidationDTO;
import com.isagiongo.pragmabrewery.validator.PilsnerValidator;

@RestController
public class BeerController {
	
	private PilsnerValidator pilsnerValidator;

	public BeerController(PilsnerValidator pilsnerValidator) {
		this.pilsnerValidator = pilsnerValidator;
	}

	@PostMapping(value="/v1/beers/{beerName}/validations")
	public ResponseEntity<?> validateTemperature(@PathVariable String beerName, @RequestBody BeerValidationDTO beerValidationDTO){
		ResultValidationDTO result = new ResultValidationDTO();
		if(pilsnerValidator.isValidTemperature(beerValidationDTO)) {
			result.setMessage("Temperature OK");
			return ResponseEntity.ok(result);
		} else {
			result.setMessage("Invalid Temperature");
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(result);
		}
	}
}
