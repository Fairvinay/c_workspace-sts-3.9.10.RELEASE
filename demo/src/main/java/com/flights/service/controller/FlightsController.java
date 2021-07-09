package com.flights.service.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flights.service.model.FlightDetails;
import com.flights.service.model.FlightRecord;
import com.flights.service.model.ProtectionFlight;
import com.flights.service.repository.FlatRepository;
import com.flights.service.util.FlightParser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Flights Controller Management System", description = "Operations pertaining to Flights in Flights Management System")

public class FlightsController {

	@Autowired 
	FlatRepository flatRespo;
	
	 /**
	   * Get all addresses
	   *
	   * @return the list
	   */
	Function<FlightRecord, ProtectionFlight> convertToProtectFlight
    = new Function<FlightRecord, ProtectionFlight>() {

    public ProtectionFlight apply(FlightRecord t) {
    	ProtectionFlight protectFlight = new ProtectionFlight();
    	FlightParser flg = new FlightParser();
    	try {
			protectFlight = 	flg.getFlightProtectData(t);
		} catch (IOException e) {
			System.out.println("conversion error ");
			
			
		}   	
     

        return protectFlight;
    }
	};
	
	
	/*
	 * @GetMapping("/allsimple")
	 * 
	 * @ApiOperation(value = "View a list of available flights no contra", response
	 * = List.class) public List<FlightRecord> getAllAddress() { return
	 * flatRespo.findAll(); }
	 */
	  @GetMapping("/all")
	  @ApiOperation(value = "View a list of available flights", response = List.class)
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Successfully retrieved flights list"),
				@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
				@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
				@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	  public List<ProtectionFlight> getAllProtectionFlights() {
		  
	     List<FlightRecord > flData = flatRespo.findAll();
	    
	     FlightParser flParser = new FlightParser();
	     
	    List< ProtectionFlight> plList =  flData.stream().map(convertToProtectFlight).collect(Collectors.toList());
	    
	     List< FlightDetails> pDetailList = new ArrayList<>();
	     
	    for (ProtectionFlight protectionFlight : plList) {
	    	FlightDetails flDetails = new FlightDetails();
	    	flDetails.setFlightLegArrivalCity(protectionFlight.getProtectionFlightLegArrivalCity());
	    	 flDetails.setFlightLegDepartureCity(protectionFlight.getProtectionFlightLegDepartureCity() );
		        flDetails.setFlightNumber(protectionFlight.getProtectionFlightNumber());
		        flDetails.setFlightLegStatusCode(protectionFlight.getProtectionFlightLegStatusCode());
		        flDetails.setFlightLegErrorCode(protectionFlight.getProtectionFlightLegErrorCode());
		      
		        flDetails.setFlightLegClassOfService(protectionFlight.getProtectionFlightLegClassOfService());
		        flDetails.setFlightLegErrorMessage(protectionFlight.getProtectionFlightLegErrorMessage());
		        pDetailList.add(flDetails);
		}
	    
	    return plList;
	  }
	  
	  @GetMapping("/allneat")
	  @ApiOperation(value = "View a list of Neat Flights ", response = List.class)
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Successfully retrieved neat flight list"),
				@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
				@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
				@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	  public List<FlightDetails> getAllProtectionFlightsNeat() {
		  
	     List<FlightRecord > flData = flatRespo.findAll();
	    
	     FlightParser flParser = new FlightParser();
	     
	    List< ProtectionFlight> plList =  flData.stream().map(convertToProtectFlight).collect(Collectors.toList());
	    
	     List< FlightDetails> pDetailList = new ArrayList<>();
	     
	    for (ProtectionFlight protectionFlight : plList) {
	    	FlightDetails flDetails = new FlightDetails();
	    	flDetails.setFlightLegArrivalCity(protectionFlight.getProtectionFlightLegArrivalCity());
	    	flDetails.setFlightLegDepartureDate(protectionFlight.getProtectionFlightLegDepartureDate());
	    	 flDetails.setFlightLegDepartureCity(protectionFlight.getProtectionFlightLegDepartureCity() );
		        flDetails.setFlightNumber(protectionFlight.getProtectionFlightNumber());
		        flDetails.setFlightLegStatusCode(protectionFlight.getProtectionFlightLegStatusCode());
		        flDetails.setFlightLegErrorCode(protectionFlight.getProtectionFlightLegErrorCode());
		      
		        flDetails.setFlightLegClassOfService(protectionFlight.getProtectionFlightLegClassOfService());
		        flDetails.setFlightLegErrorMessage(protectionFlight.getProtectionFlightLegErrorMessage());
		        pDetailList.add(flDetails);
		}
	    
	    return pDetailList;
	  }
	  
}
