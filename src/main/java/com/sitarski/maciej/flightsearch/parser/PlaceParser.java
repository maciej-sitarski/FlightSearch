package com.sitarski.maciej.flightsearch.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import com.sitarski.maciej.flightsearch.jsonApi.jsonPlacesApi.PlaceList;
import org.springframework.stereotype.Service;

@Service
public class PlaceParser {

  private ObjectMapper objectMapper = new ObjectMapper();

  public PlaceList parsePlaces(String city, String currency) throws UnirestException, IOException {

    HttpResponse<String> response = Unirest.get(String.format(
        "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/PL/%s/en-PL/?query=%s",
        currency, city))
        .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
        .header("x-rapidapi-key", "4a11ecaf22msh48198c7c39b5dc7p12193ejsn07edf2594542")
        .asString();

    JsonNode jsonNode = objectMapper.readTree(String.valueOf(response));
    return objectMapper.readValue(jsonNode.toString(),
        new TypeReference<PlaceList>() {
        });
  }
}
