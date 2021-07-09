package com.flights.service.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ProtectionFlightMixin {
	
	 @JsonCreator
	    public ProtectionFlightMixin(
	            @JsonProperty("city") String city,
	            @JsonProperty("state") String state,
	             @JsonProperty("FlightLegDepartureDate") Date  flightLegDepartureDate,
	        	 @JsonProperty("FlightLegDepartureCity") String flightLegDepartureCity,
	        	 @JsonProperty("FlightNumber") int flightNumber,
	        	 @JsonProperty("FlightLegStatusCode") String flightLegStatusCode,
	        	 @JsonProperty("FlightLegErrorCode") float flightLegErrorCode,
	        	 @JsonProperty("FlightLegArrivalCity") String flightLegArrivalCity,
	        	 @JsonProperty("FlightLegClassOfService") String flightLegClassOfService,
	        	 @JsonProperty("FlightLegErrorMessage") String flightLegErrorMessage
	            ) {
		 
		 
	        System.out.println("Wont be called");
	    }
}
