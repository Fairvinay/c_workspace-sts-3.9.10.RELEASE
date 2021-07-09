package com.flights.service.model;

public class FlightRequiringReprotection {
	private float flightNumber;
	private String flightLegDepartureDate;
	private String flightLegDepartureCity;
	private String flightLegArrivalCity;
	private String flightClassOfService;
	private String flightStatusCode;
	private float flightErrorCode;
	private String flightErrorMessage;

	// Getter Methods

	public float getFlightNumber() {
		return flightNumber;
	}

	public String getFlightLegDepartureDate() {
		return flightLegDepartureDate;
	}

	public String getFlightLegDepartureCity() {
		return flightLegDepartureCity;
	}

	public String getFlightLegArrivalCity() {
		return flightLegArrivalCity;
	}

	public String getFlightClassOfService() {
		return flightClassOfService;
	}

	public String getFlightStatusCode() {
		return flightStatusCode;
	}

	public float getFlightErrorCode() {
		return flightErrorCode;
	}

	public String getFlightErrorMessage() {
		return flightErrorMessage;
	}

	// Setter Methods

	public void setFlightNumber(float flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setFlightLegDepartureDate(String flightLegDepartureDate) {
		this.flightLegDepartureDate = flightLegDepartureDate;
	}

	public void setFlightLegDepartureCity(String flightLegDepartureCity) {
		this.flightLegDepartureCity = flightLegDepartureCity;
	}

	public void setFlightLegArrivalCity(String flightLegArrivalCity) {
		this.flightLegArrivalCity = flightLegArrivalCity;
	}

	public void setFlightClassOfService(String flightClassOfService) {
		this.flightClassOfService = flightClassOfService;
	}

	public void setFlightStatusCode(String flightStatusCode) {
		this.flightStatusCode = flightStatusCode;
	}

	public void setFlightErrorCode(float flightErrorCode) {
		this.flightErrorCode = flightErrorCode;
	}

	public void setFlightErrorMessage(String flightErrorMessage) {
		this.flightErrorMessage = flightErrorMessage;
	}

}
