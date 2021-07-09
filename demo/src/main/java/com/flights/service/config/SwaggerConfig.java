package com.flights.service.config;

import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;



import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
/**	
 * addd a restricted path
 **/
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
								.apis(RequestHandlerSelectors.basePackage("com.flights.service.controller"))
				.paths(Predicates.and(Predicates.not(PathSelectors.regex("/api/v1.*")),Predicates.not(PathSelectors.regex("/api/v2.*"))))
				//.paths(Predicates.not(PathSelectors.regex("/api/v1.*")))//.paths(PathSelectors.regex("(?!/api/v1).+"))
				// works			.paths(PathSelectors.ant("/api/user[s]/**")) //(PathSelectors.regex("/.*")) //PathSelectors.regex("/api/v1") PathSelectors.any()
				.build();
				/*
				.apis(RequestHandlerSelectors.basePackage("com.staxrt.tutorial.controller"))
				.paths(Predicates.or(PathSelectors.regex("/users"), PathSelectors.regex("/ball"))) //(PathSelectors.regex("/.*")) //PathSelectors.regex("/api/v1") PathSelectors.any()
				.build().pathMapping("/").apiInfo(apiEndPointsInfo());
				*/
	}
	
	


	private ApiInfo apiEndPointsInfo() {

		return new ApiInfoBuilder().title("Spring Boot REST API")
				.description("Flights Management REST API")
				.contact(new Contact("Vinayak Anvekar", "www.mizoba.com", "vinayakA2@hexaware.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.build();

	}

}
