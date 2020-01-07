package com.sitarski.maciej.flightsearch.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.Itinerary;
import org.springframework.stereotype.Service;

@Service
public class LiveFlightSearchParser {

  private ObjectMapper objectMapper = new ObjectMapper();

  public void createSession() throws UnirestException {

//    StringBuilder sringBuilder = new StringBuilder();
//    sringBuilder.append("sdadsa");

    HttpResponse<String> response = Unirest.post("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0")
        .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
        .header("x-rapidapi-key", "4a11ecaf22msh48198c7c39b5dc7p12193ejsn07edf2594542")
        .header("content-type", "application/x-www-form-urlencoded")
        .body("inboundDate=2019-09-10&cabinClass=business&children=0&infants=0&country=US&currency=USD&locale=en-US&originPlace=SFO-sky&destinationPlace=LHR-sky&outboundDate=2019-09-01&adults=1")
        .asString();

    response.getHeaders().get("location");
  }

  public Itinerary parseItinerary() throws UnirestException, IOException {


    HttpResponse<String> response = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/en-US")
        .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
        .header("x-rapidapi-key", "4a11ecaf22msh48198c7c39b5dc7p12193ejsn07edf2594542")
        .asString();

    JsonNode jsonNode = objectMapper.readTree(String.valueOf(response));
    return objectMapper.readValue(jsonNode.toString(),
        new TypeReference<Itinerary>() {
        });
  }

}
