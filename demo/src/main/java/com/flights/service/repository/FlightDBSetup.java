package com.flights.service.repository;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flights.service.model.FlightRecord;
import com.flights.service.util.FlightParser;

@Component
public class FlightDBSetup {

	@Autowired
	FlatRepository flatReport;

	@PostConstruct
	public void initialiseDB() {
		File  myFile = 		getJSONFile();
		FlightParser flg = new FlightParser();
		FlightRecord flRec = new FlightRecord();
		HashMap<Integer, FlightRecord> flMap =  new HashMap<>();
		try {
			
			 flg.getFlightDataString(myFile,flMap );
			
			
			flatReport.saveAll(flMap.values());
			
		} catch (IOException e) {
			System.out.println("");
		}
		
		
	}

	public File getJSONFile() {

		File obj = new File("src/main/java/com/flights/service/util/FlightJsonFile.json");

		return obj;
	}

}
