package com.isagiongo.pragmabrewery.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isagiongo.pragmabrewery.config.ConfigBeer;
import com.isagiongo.pragmabrewery.controller.dto.BeerValidationDTO;
import com.isagiongo.pragmabrewery.controller.dto.ResultValidationDTO;
import com.isagiongo.pragmabrewery.validator.BeerValidator;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class BeerController {

	private Map<String, BeerValidator> mapBeerValidator;

	private ConfigBeer configBeer;

	public BeerController(Map<String, BeerValidator> mapBeerValidator, ConfigBeer configBeer) {
		this.mapBeerValidator = mapBeerValidator;
		this.configBeer = configBeer;
	}

	@ApiOperation(value = "Validate temperature")
	@PostMapping(value = "/v1/beers/{beerName}/validations")
	public ResponseEntity<ResultValidationDTO> validateTemperature(@ApiParam (required = true, value="Beer Name - Options: Lager, IPA, Stout, Pilsner, WheatBeer, PaleAle") @PathVariable String beerName,
			@Valid @RequestBody @ApiParam (required = true, value="Temperature") BeerValidationDTO beerValidationDTO) {
		ResultValidationDTO result = new ResultValidationDTO();
		
		String validatorName = configBeer.getMapBeer().get(beerName.toLowerCase());
		if (validatorName != null) {
			BeerValidator beerValidator = mapBeerValidator.get(validatorName);
			if (beerValidator.isValidTemperature(beerValidationDTO)) {
				result.setMessage("Temperature OK");
				return ResponseEntity.ok(result);
			} else {
				result.setMessage("Inappropriate Temperature");
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(result);
			}
		} else {
			result.setMessage("Invalid Beer");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}
}