package com.flights.service.model;

import java.util.ArrayList;

public class ScheduleChangeAlternativeReprotection {

	ArrayList<Object> reprotectionHeaderList = new ArrayList<Object>();
	private float repDataCnt;
	ReprotectionData ReprotectionDataObject;
	private String version;
	private String dmsHeaderText;

	// Getter Methods

	public float getRepDataCnt() {
		return repDataCnt;
	}

	public ReprotectionData getReprotectionData() {
		return ReprotectionDataObject;
	}

	public String getVersion() {
		return version;
	}

	public String getDmsHeaderText() {
		return dmsHeaderText;
	}

	// Setter Methods

	public void setRepDataCnt(float repDataCnt) {
		this.repDataCnt = repDataCnt;
	}

	public void setReprotectionData(ReprotectionData reprotectionDataObject) {
		this.ReprotectionDataObject = reprotectionDataObject;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setDmsHeaderText(String dmsHeaderText) {
		this.dmsHeaderText = dmsHeaderText;
	}
}
