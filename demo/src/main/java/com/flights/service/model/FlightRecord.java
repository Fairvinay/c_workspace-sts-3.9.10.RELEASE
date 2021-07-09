package com.flights.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class FlightRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int runId;

	@Column(name = "flightData", columnDefinition = "CLOB NOT NULL")
	@Lob
	private String flightData;

	public int getRunId() {
		return runId;
	}

	public void setRunId(int runId) {
		this.runId = runId;
	}

	public String getFlightData() {
		return flightData;
	}

	public void setFlightData(String flightData) {
		this.flightData = flightData;
	}

}
