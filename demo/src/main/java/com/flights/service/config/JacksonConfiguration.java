package com.flights.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.flights.service.model.ProtectionFlight;
import com.flights.service.model.ProtectionFlightMixin;

import java.util.Date;


@Configuration
public class JacksonConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        mapper.addMixIn(ProtectionFlight.class, ProtectionFlightMixin.class);
         System.out.println("******* JacksonConfiguration ***** ");
		
		
		SimpleModule module = new SimpleModule("JSONModule", new Version(2, 0, 0, null, null, null));
        //module.addSerializer(Date.class, new DateSerializer());
       // module.addDeserializer(Date.class, new DateDeserializer());
        // Add more here ...
        mapper.registerModule(module);

		 
		 
        return mapper;
    }
}
