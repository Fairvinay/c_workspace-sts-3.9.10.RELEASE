package com.flights.service.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flights.service.model.FlightRecord;
import com.flights.service.model.ProtectionFlight;
import com.flights.service.util.FlightParser;

public interface FlatRepository extends JpaRepository<FlightRecord, Integer> {

	@Override
	default <S extends FlightRecord> List<S> saveAll(Iterable<S> entities) {

		entities.forEach(flg -> {
			if (flg.getRunId() > -1) {
				// check is flight data exists
				Optional<FlightRecord> chekPre = findById(flg.getRunId());
				if (chekPre.isPresent()) {
					System.out.println("flight record allready present " + flg.getRunId());
				} else {
					save(flg);
					System.out.println("flight record saved " + flg.getRunId());
					FlightParser flgParser = new FlightParser();
					try {
						
						ProtectionFlight prData = flgParser.getFlightProtectData(flg);
						System.out.println("Saved ProtectionFlight : " + prData);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("error parsing Flight Record ");
					}
				}
			} else {

			}
		});

		return null;
	}
}
