package com.isagiongo.pragmabrewery.controller;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "configuration")
public class ConfigBeer {
	
	private Map<String, String> mapBeer;
	
	public Map<String, String> getMapBeer() {
		return mapBeer;
	}
	
	public void setMapBeer(Map<String, String> mapBeer) {
		this.mapBeer = mapBeer;
	}

}
