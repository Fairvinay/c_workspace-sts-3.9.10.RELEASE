package com.flights.service.model;

public class FlightProtectionData {
	private float id;
	private String evtType;
	EvtMsg EvtMsgObject;
	private float crtnGts;

	// Getter Methods

	public float getId() {
		return id;
	}

	public String getEvtType() {
		return evtType;
	}

	public EvtMsg getEvtMsg() {
		return EvtMsgObject;
	}

	public float getCrtnGts() {
		return crtnGts;
	}

	// Setter Methods

	public void setId(float id) {
		this.id = id;
	}

	public void setEvtType(String evtType) {
		this.evtType = evtType;
	}

	public void setEvtMsg(EvtMsg evtMsgObject) {
		this.EvtMsgObject = evtMsgObject;
	}

	public void setCrtnGts(float crtnGts) {
		this.crtnGts = crtnGts;
	}
}


