package com.flights.service.model;

public class ConnectingProtectionFlight {

	private String connectingFlightLegDepartureDate;
	private String connectingFlightLegDepartureCity;
	private String connectingFlightLegArrivalCity;
	private String connectingFlightClassOfService;
	private float connectingFlightNumber;
	private String connectingFlightStatusCode;
	private float connectingFlightErrorCode;
	private String connectingFlightErrorMessage;

	// Getter Methods

	public String getConnectingFlightLegDepartureDate() {
		return connectingFlightLegDepartureDate;
	}

	public String getConnectingFlightLegDepartureCity() {
		return connectingFlightLegDepartureCity;
	}

	public String getConnectingFlightLegArrivalCity() {
		return connectingFlightLegArrivalCity;
	}

	public String getConnectingFlightClassOfService() {
		return connectingFlightClassOfService;
	}

	public float getConnectingFlightNumber() {
		return connectingFlightNumber;
	}

	public String getConnectingFlightStatusCode() {
		return connectingFlightStatusCode;
	}

	public float getConnectingFlightErrorCode() {
		return connectingFlightErrorCode;
	}

	public String getConnectingFlightErrorMessage() {
		return connectingFlightErrorMessage;
	}

	// Setter Methods

	public void setConnectingFlightLegDepartureDate(String connectingFlightLegDepartureDate) {
		this.connectingFlightLegDepartureDate = connectingFlightLegDepartureDate;
	}

	public void setConnectingFlightLegDepartureCity(String connectingFlightLegDepartureCity) {
		this.connectingFlightLegDepartureCity = connectingFlightLegDepartureCity;
	}

	public void setConnectingFlightLegArrivalCity(String connectingFlightLegArrivalCity) {
		this.connectingFlightLegArrivalCity = connectingFlightLegArrivalCity;
	}

	public void setConnectingFlightClassOfService(String connectingFlightClassOfService) {
		this.connectingFlightClassOfService = connectingFlightClassOfService;
	}

	public void setConnectingFlightNumber(float connectingFlightNumber) {
		this.connectingFlightNumber = connectingFlightNumber;
	}

	public void setConnectingFlightStatusCode(String connectingFlightStatusCode) {
		this.connectingFlightStatusCode = connectingFlightStatusCode;
	}

	public void setConnectingFlightErrorCode(float connectingFlightErrorCode) {
		this.connectingFlightErrorCode = connectingFlightErrorCode;
	}

	public void setConnectingFlightErrorMessage(String connectingFlightErrorMessage) {
		this.connectingFlightErrorMessage = connectingFlightErrorMessage;
	}

}
