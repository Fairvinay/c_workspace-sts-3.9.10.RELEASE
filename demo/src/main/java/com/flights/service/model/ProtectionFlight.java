package com.flights.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@JsonIgnoreProperties(value = { "protectionFlightLegErrorMessage", "protectionFlightLegErrorCode","protectionFlightLegStatusCode","protectionFlightLegClassOfService" })
@ApiModel(description = "All details about the Flight Protection Data. ")
public class ProtectionFlight {

	 @ApiModelProperty(notes = "The departure date")
	private String protectionFlightLegDepartureDate;
	 @ApiModelProperty(notes = "The depature city ")
	private String protectionFlightLegDepartureCity;
	 @ApiModelProperty(notes = "The flight number")
	private float protectionFlightNumber;
	private String protectionFlightLegStatusCode;
	private float protectionFlightLegErrorCode;
	 @ApiModelProperty(notes = "The arrival city")
	private String protectionFlightLegArrivalCity;
	private String protectionFlightLegClassOfService;
	private String protectionFlightLegErrorMessage;

	// Getter Methods
	//@JsonProperty("FlightLegDepartureDate")
	public String getProtectionFlightLegDepartureDate() {
		return protectionFlightLegDepartureDate;
	}

	public String getProtectionFlightLegDepartureCity() {
		return protectionFlightLegDepartureCity;
	}

	public float getProtectionFlightNumber() {
		return protectionFlightNumber;
	}
	@JsonIgnore
	public String getProtectionFlightLegStatusCode() {
		return protectionFlightLegStatusCode;
	}

	@JsonIgnore
	public float getProtectionFlightLegErrorCode() {
		return protectionFlightLegErrorCode;
	}

	public String getProtectionFlightLegArrivalCity() {
		return protectionFlightLegArrivalCity;
	}

	public String getProtectionFlightLegClassOfService() {
		return protectionFlightLegClassOfService;
	}

	@JsonIgnore
	public String getProtectionFlightLegErrorMessage() {
		return protectionFlightLegErrorMessage;
	}

	// Setter Methods
	

	public void setProtectionFlightLegDepartureDate(String protectionFlightLegDepartureDate) {
		this.protectionFlightLegDepartureDate = protectionFlightLegDepartureDate;
	}

	////@JsonProperty("FlightLegDepartureCity")

	public void setProtectionFlightLegDepartureCity(String protectionFlightLegDepartureCity) {
		this.protectionFlightLegDepartureCity = protectionFlightLegDepartureCity;
	}

	//@JsonProperty("FlightNumber")

	public void setProtectionFlightNumber(float protectionFlightNumber) {
		this.protectionFlightNumber = protectionFlightNumber;
	}

	//@JsonProperty("FlightLegStatusCode")
	//@JsonIgnore(value = true)
	public void setProtectionFlightLegStatusCode(String protectionFlightLegStatusCode) {
		this.protectionFlightLegStatusCode = protectionFlightLegStatusCode;
	}

	//@JsonProperty("FlightLegErrorCode")
	//@JsonIgnore(value = true)
	public void setProtectionFlightLegErrorCode(float protectionFlightLegErrorCode) {
		this.protectionFlightLegErrorCode = protectionFlightLegErrorCode;
	}

	//@JsonProperty("FlightLegArrivalCity")

	public void setProtectionFlightLegArrivalCity(String protectionFlightLegArrivalCity) {
		this.protectionFlightLegArrivalCity = protectionFlightLegArrivalCity;
	}

	//@JsonProperty("FlightLegClassOfService")
	//@JsonIgnore(value = true)
	public void setProtectionFlightLegClassOfService(String protectionFlightLegClassOfService) {
		this.protectionFlightLegClassOfService = protectionFlightLegClassOfService;
	}

	////@JsonProperty("FlightLegErrorMessage")
	//@JsonIgnore(value = true)
	public void setProtectionFlightLegErrorMessage(String protectionFlightLegErrorMessage) {
		this.protectionFlightLegErrorMessage = protectionFlightLegErrorMessage;
	}

	@Override
	public String toString() {
		return "ProtectionFlight [FlightLegDepartureDate=" + protectionFlightLegDepartureDate
				+ ", FlightLegDepartureCity=" + protectionFlightLegDepartureCity + ", FlightNumber="
				+ protectionFlightNumber + ", FlightLegStatusCode=" + protectionFlightLegStatusCode
				+ ", FlightLegErrorCode=" + protectionFlightLegErrorCode + ", FlightLegArrivalCity="
				+ protectionFlightLegArrivalCity + ", FlightLegClassOfService=" + protectionFlightLegClassOfService
				+ ", FlightLegErrorMessage=" + protectionFlightLegErrorMessage + "]";
	}

}
