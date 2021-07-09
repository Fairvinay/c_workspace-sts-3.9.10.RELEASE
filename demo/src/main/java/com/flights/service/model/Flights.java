package com.flights.service.model;

import java.util.Date;


public class Flights {

	Date flightDepatureDate;
	
	String flightDepatureCity;
	int flightNumber;
	String flightStatusCode;
	
	int flightErrorCode;
	String flightArrivalCity; // : "MSP",
    String flightClassOfService; // ": "CL",
    String flightErrorMessage; // " 
    
    
    
	public Date getFlightDepatureDate() {
		return flightDepatureDate;
	}
	public void setFlightDepatureDate(Date flightDepatureDate) {
		this.flightDepatureDate = flightDepatureDate;
	}
	public String getFlightDepatureCity() {
		return flightDepatureCity;
	}
	public void setFlightDepatureCity(String flightDepatureCity) {
		this.flightDepatureCity = flightDepatureCity;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightStatusCode() {
		return flightStatusCode;
	}
	public void setFlightStatusCode(String flightStatusCode) {
		this.flightStatusCode = flightStatusCode;
	}
	public int getFlightErrorCode() {
		return flightErrorCode;
	}
	public void setFlightErrorCode(int flightErrorCode) {
		this.flightErrorCode = flightErrorCode;
	}
	public String getFlightArrivalCity() {
		return flightArrivalCity;
	}
	public void setFlightArrivalCity(String flightArrivalCity) {
		this.flightArrivalCity = flightArrivalCity;
	}
	public String getFlightClassOfService() {
		return flightClassOfService;
	}
	public void setFlightClassOfService(String flightClassOfService) {
		this.flightClassOfService = flightClassOfService;
	}
	public String getFlightErrorMessage() {
		return flightErrorMessage;
	}
	public void setFlightErrorMessage(String flightErrorMessage) {
		this.flightErrorMessage = flightErrorMessage;
	}
    
    

}
