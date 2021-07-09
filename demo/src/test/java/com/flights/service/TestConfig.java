package com.flights.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
	
	@Bean (name="testBean")
	@Qualifier("testBean")
	   public TestBean testBean(){
	      return new TestBean();
	   }
    
	@Bean(name="myBean")
	
	public TestBean myBean() {
		return new TestBean();
	}
}
