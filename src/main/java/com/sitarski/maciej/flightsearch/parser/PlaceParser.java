package com.sitarski.maciej.flightsearch.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.jsonApi.jsonPlacesApi.PlaceList;
import java.io.IOException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class PlaceParser {

  private ObjectMapper objectMapper = new ObjectMapper();

  private final String firstHeaderName = "x-rapidapi-host";
  private final String secondHeaderName = "x-rapidapi-key";
  private final String firstHeaderValue = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";
  private final String secondHeaderValue = "4a11ecaf22msh48198c7c39b5dc7p12193ejsn07edf2594542";

  public PlaceList parsePlaces(String city, String currency) throws UnirestException, IOException {

    HttpResponse<String> response = Unirest.get(String.format(
        "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/PL/%s/en-PL/?query=%s",
        currency, city))
        .header(firstHeaderName, firstHeaderValue)
        .header(secondHeaderName, secondHeaderValue)
        .asString();

    return objectMapper.readValue(response.getBody(), PlaceList.class);
  }
}
