package com.flights.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@JsonIgnoreProperties(value = { "flightLegErrorMessage", "flightLegErrorCode","flightLegStatusCode","flightLegClassOfService" })
@ApiModel(description = "All details about the Flight Protection Data. ")
public class FlightDetails {

	 @ApiModelProperty(notes = "The departure date")
	private String flightLegDepartureDate;
	 @ApiModelProperty(notes = "The depature city ")
	private String flightLegDepartureCity;
	 @ApiModelProperty(notes = "The flight number")
	private float flightNumber;
	private String flightLegStatusCode;
	private float flightLegErrorCode;
	 @ApiModelProperty(notes = "The arrival city")
	private String flightLegArrivalCity;
	private String flightLegClassOfService;
	private String flightLegErrorMessage;

	// Getter Methods
	//@JsonProperty("FlightLegDepartureDate")
	public String getFlightLegDepartureDate() {
		return flightLegDepartureDate;
	}

	public String getFlightLegDepartureCity() {
		return flightLegDepartureCity;
	}

	public float getFlightNumber() {
		return flightNumber;
	}
	@JsonIgnore
	public String getFlightLegStatusCode() {
		return flightLegStatusCode;
	}

	@JsonIgnore
	public float getFlightLegErrorCode() {
		return flightLegErrorCode;
	}

	public String getFlightLegArrivalCity() {
		return flightLegArrivalCity;
	}

	public String getFlightLegClassOfService() {
		return flightLegClassOfService;
	}

	@JsonIgnore
	public String getFlightLegErrorMessage() {
		return flightLegErrorMessage;
	}

	// Setter Methods
	

	public void setFlightLegDepartureDate(String flightLegDepartureDate) {
		this.flightLegDepartureDate = flightLegDepartureDate;
	}

	////@JsonProperty("FlightLegDepartureCity")

	public void setFlightLegDepartureCity(String flightLegDepartureCity) {
		this.flightLegDepartureCity = flightLegDepartureCity;
	}

	//@JsonProperty("FlightNumber")

	public void setFlightNumber(float flightNumber) {
		this.flightNumber = flightNumber;
	}

	//@JsonProperty("FlightLegStatusCode")
	//@JsonIgnore(value = true)
	public void setFlightLegStatusCode(String flightLegStatusCode) {
		this.flightLegStatusCode = flightLegStatusCode;
	}

	//@JsonProperty("FlightLegErrorCode")
	//@JsonIgnore(value = true)
	public void setFlightLegErrorCode(float flightLegErrorCode) {
		this.flightLegErrorCode = flightLegErrorCode;
	}

	//@JsonProperty("FlightLegArrivalCity")

	public void setFlightLegArrivalCity(String flightLegArrivalCity) {
		this.flightLegArrivalCity = flightLegArrivalCity;
	}

	//@JsonProperty("FlightLegClassOfService")
	//@JsonIgnore(value = true)
	public void setFlightLegClassOfService(String flightLegClassOfService) {
		this.flightLegClassOfService = flightLegClassOfService;
	}

	////@JsonProperty("FlightLegErrorMessage")
	//@JsonIgnore(value = true)
	public void setFlightLegErrorMessage(String flightLegErrorMessage) {
		this.flightLegErrorMessage = flightLegErrorMessage;
	}

	@Override
	public String toString() {
		return "flight [FlightLegDepartureDate=" + flightLegDepartureDate
				+ ", FlightLegDepartureCity=" + flightLegDepartureCity + ", FlightNumber="
				+ flightNumber + ", FlightLegStatusCode=" + flightLegStatusCode
				+ ", FlightLegErrorCode=" + flightLegErrorCode + ", FlightLegArrivalCity="
				+ flightLegArrivalCity + ", FlightLegClassOfService=" + flightLegClassOfService
				+ ", FlightLegErrorMessage=" + flightLegErrorMessage + "]";
	}

}
