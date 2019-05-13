package com.isagiongo.pragmabrewery.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private final ResponseMessage m200 = simpleMessage (200, "Temperature OK");
	private final ResponseMessage m417 = simpleMessage (417, "Inappropriate Temperature");
	private final ResponseMessage m404 = simpleMessage (400, "Bad Request");

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.POST, Arrays.asList(m200, m404, m417))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.isagiongo.pragmabrewery.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ResponseMessage simpleMessage(int code, String msg) {
		return new ResponseMessageBuilder().code(code).message(msg).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Api PragmaBrewery", "Monitoring beer temperature",
				"Version 1.0", "", new Contact("Isa Giongo","","isagiongo@gmail.com"),
				"Non Commercial use", "", Collections.emptyList());
	}

}
