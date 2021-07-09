package com.flights.service.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.flights.service.model.EvtMsg;
import com.flights.service.model.FlightRecord;
import com.flights.service.model.Flights;
import com.flights.service.model.ProtectionFlight;

public class FlightParser {

	
	public static void main(String[] args) {
		FlightParser flg = new FlightParser();
		
		File jsFile = flg.getJSONFile();
		
		try {
			ProtectionFlight prData = flg.getFlightDataBasic(jsFile);
			
			System.out.println("ProtectionFlight data " + prData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public  File getJSONFile ( ) {
		
		//ClassLoader clLoader = this.getClass().getClassLoader();
		//String path = clLoader.getResource("FlightJsonFile.json").getPath();
		//+ "/demo/src/main/java/com/flights/service/util/FlightJsonFile.json"
		File obj = new File("src/main/java/com/flights/service/util/FlightJsonFile.json" );
		
		return obj;
	}
	
	
	public  Flights getFlightData(FlightRecord flightRecord) throws JsonParseException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getFactory();

		// Escape till we find the ProtectionFlight string
		int protectionStringIdx = flightRecord.getFlightData().indexOf("protectionFlight");
		String protectionSubString = flightRecord.getFlightData().substring(protectionStringIdx);
		int protectionStringEndIdx = protectionSubString.indexOf("}");

		String protectionJsonString = "";
		ProtectionFlight protectFlight = null;
		if (protectionStringIdx > -1 && protectionStringEndIdx > -1) {

			protectionJsonString = protectionSubString.substring(protectionStringIdx, protectionStringEndIdx + 1);

			protectFlight = mapper.readValue(protectionJsonString, ProtectionFlight.class);

		}

		return null;
	}

	public ProtectionFlight getFlightProtectData(FlightRecord flightRecord) throws JsonParseException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getFactory();

		// Escape till we find the ProtectionFlight string
		int protectionStringIdx = flightRecord.getFlightData().indexOf("protectionFlight");
		String protectionSubString = flightRecord.getFlightData().substring(protectionStringIdx);
		int protectionStringEndIdx = protectionSubString.indexOf("}");
		int protectionOpenCurl = protectionSubString.indexOf("{");

		String protectionJsonString = "";
		ProtectionFlight protectFlight = null;
		if (protectionOpenCurl > -1 && protectionStringEndIdx > -1) {

			protectionJsonString = protectionSubString.substring(protectionOpenCurl, protectionStringEndIdx + 1);

			protectFlight = mapper.readValue(protectionJsonString, ProtectionFlight.class);

		}

		return protectFlight;
	}
	public String getFlightDataString(File fl,  HashMap<Integer, FlightRecord> flMap) throws JsonParseException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getFactory();
		
		
		ArrayNode js = mapper.readValue(fl,ArrayNode.class);
		System.out.println("This is JSON "+js.toPrettyString());
		
		int i=0; 
		while(js.size()>i && i < js.size()) {
			
		 FlightRecord flg = new FlightRecord();
		 int runId  = Integer.parseInt(((JsonNode)js.get(i).get("id")).toString());
		 String data  = ((JsonNode)js.get(i)).toString();
		 flg.setRunId(runId);
		 flg.setFlightData(data);
		 
		 flMap.put(runId, flg);
		 i++;
		 
		}

		return js.toPrettyString();
	}
	
	
	public ProtectionFlight getFlightDataBasic(File fl) throws JsonParseException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getFactory();
		
		
		ArrayNode js = mapper.readValue(fl,ArrayNode.class);
		System.out.println("This is JSON "+js.toPrettyString());
		
		//EvtMsg[] myObjectslObj = mapper.readValue(stb.toString() ,EvtMsg[].class);
		 System.out.println(js.get(0).get("evtMsg").get("scheduleChangeAlternativeReprotection").get("reprotectionData").get("protectionFlight"));
		 String protectionJsonString = ((JsonNode)js.get(0).get("evtMsg").get("scheduleChangeAlternativeReprotection").get("reprotectionData").get("protectionFlight")).toString();
		 ProtectionFlight protectFlight = mapper.readValue(protectionJsonString, ProtectionFlight.class);
		 
		 System.out.println(" prtoectFlight "+ protectFlight);
		//JsonNode singleNode = actualObj.
		//long id = actualObj.path("id").asLong();
		//System.out.println("id : " + id);

		//ProtectionFlight protectFlight = new ProtectionFlight();
		
		// Get evtMsg
//		JsonNode evtMsgNode = actualObj.path("evtMsg");
//		if (!evtMsgNode.isMissingNode()) { // if "evtMsgNode" node is exist
//
//			parseEvtMsgNode(evtMsgNode,protectFlight);
//
//		}

		return protectFlight;
	}
	
	
	
	public ProtectionFlight getFlightDataBasic(FlightRecord flightRecord) throws JsonParseException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getFactory();

		JsonParser parser = factory.createParser(flightRecord.getFlightData());
		
		JsonNode actualObj = mapper.readTree(parser);

		long id = actualObj.path("id").asLong();
		System.out.println("id : " + id);

		ProtectionFlight protectFlight = new ProtectionFlight();
		
		// Get evtMsg
		JsonNode evtMsgNode = actualObj.path("evtMsg");
		if (!evtMsgNode.isMissingNode()) { // if "evtMsgNode" node is exist

			parseEvtMsgNode(evtMsgNode,protectFlight);

		}

		return protectFlight;
	}

	private void parseEvtMsgNode(JsonNode evtMsgNode,ProtectionFlight protectFligh ) {

		// Get evtMsg
		JsonNode schAlterReproNode = evtMsgNode.path("scheduleChangeAlternativeReprotection");
		if (!schAlterReproNode.isMissingNode()) {

			JsonNode proFlghtNde = schAlterReproNode.path("protectionFlight");
        /*
         
         "protectionFlightLegDepartureDate": "2019-12-02 12:17:31",
          "protectionFlightLegDepartureCity": "ATL",
          "protectionFlightNumber": 123,
          "protectionFlightLegStatusCode": "S",
          "protectionFlightLegErrorCode": 200,
          "protectionFlightLegArrivalCity": "MSP",
          "protectionFlightLegClassOfService": "CL",
          "protectionFlightLegErrorMessage": "Success"
         
        */
			if (!proFlghtNde.isMissingNode()) { // if "protectionFlight" node is exist
				System.out.println("protectionFlightLegDepartureDate : " + proFlghtNde.path("protectionFlightLegDepartureDate").asText());
				System.out.println("protectionFlightLegDepartureCity : " + proFlghtNde.path("protectionFlightLegDepartureCity").asText());
				System.out.println("protectionFlightNumber : " + proFlghtNde.path("protectionFlightNumber").asText());
				System.out.println("protectionFlightLegStatusCode : " + proFlghtNde.path("protectionFlightLegStatusCode").asText());
				System.out.println("protectionFlightLegErrorCode : " + proFlghtNde.path("protectionFlightLegErrorCode").asText());
				System.out.println("protectionFlightLegArrivalCity : " + proFlghtNde.path("protectionFlightLegArrivalCity").asText());
				System.out.println("protectionFlightLegClassOfService : " + proFlghtNde.path("protectionFlightLegClassOfService").asText());
				System.out.println("protectionFlightLegErrorMessage : " + proFlghtNde.path("protectionFlightLegErrorMessage").asText());
				
				
		        protectFligh.setProtectionFlightLegDepartureCity(proFlghtNde.path("protectionFlightLegDepartureCity").asText());
		        protectFligh.setProtectionFlightNumber(Integer.parseInt(proFlghtNde.path("protectionFlightNumber").asText()));
		        protectFligh.setProtectionFlightLegStatusCode(proFlghtNde.path("protectionFlightLegStatusCode").asText());
		        protectFligh.setProtectionFlightLegErrorCode(Integer.parseInt(proFlghtNde.path("protectionFlightLegErrorCode").asText()));
		        protectFligh.setProtectionFlightLegArrivalCity(proFlghtNde.path("protectionFlightLegArrivalCity").asText());
		        protectFligh.setProtectionFlightLegClassOfService(proFlghtNde.path("protectionFlightLegClassOfService").asText());
		        protectFligh.setProtectionFlightLegErrorMessage(proFlghtNde.path("protectionFlightLegErrorMessage").asText());
				
			}
		}

	}
}
