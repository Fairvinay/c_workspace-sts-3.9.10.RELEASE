package com.flights.service.model;

public class ReprotectionData {
	FlightRequiringReprotection FlightRequiringReprotectionObject;
	ProtectionFlight ProtectionFlightObject;
	ConnectingProtectionFlight ConnectingProtectionFlightObject;

	// Getter Methods

	public FlightRequiringReprotection getFlightRequiringReprotection() {
		return FlightRequiringReprotectionObject;
	}

	public ProtectionFlight getProtectionFlight() {
		return ProtectionFlightObject;
	}

	public ConnectingProtectionFlight getConnectingProtectionFlight() {
		return ConnectingProtectionFlightObject;
	}

	// Setter Methods

	public void setFlightRequiringReprotection(FlightRequiringReprotection flightRequiringReprotectionObject) {
		this.FlightRequiringReprotectionObject = flightRequiringReprotectionObject;
	}

	public void setProtectionFlight(ProtectionFlight protectionFlightObject) {
		this.ProtectionFlightObject = protectionFlightObject;
	}

	public void setConnectingProtectionFlight(ConnectingProtectionFlight connectingProtectionFlightObject) {
		this.ConnectingProtectionFlightObject = connectingProtectionFlightObject;
	}
}
