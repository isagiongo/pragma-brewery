package com.isagiongo.pragmabrewery.controller.dto;

import javax.validation.constraints.NotNull;

public class BeerValidationDTO {
	
	@NotNull(message = "Temperature is required")
	private Double temperature;

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
}
