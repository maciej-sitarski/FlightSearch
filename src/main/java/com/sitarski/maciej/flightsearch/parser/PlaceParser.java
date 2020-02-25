package com.sitarski.maciej.flightsearch.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.jsonApi.jsonPlacesApi.PlaceList;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PlaceParser {

  private ObjectMapper objectMapper = new ObjectMapper();
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final String firstHeaderName = "x-rapidapi-host";
  private final String secondHeaderName = "x-rapidapi-key";
  private final String firstHeaderValue = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

  @Value("${API_Key}")
  private String API_Key;

  public PlaceList parsePlaces(String city) throws UnirestException, IOException {

    logger.info("Parse places to objects");

    HttpResponse<String> response = Unirest.get(String.format(
        "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/UK/GBP/en-GB/?query=%s",
         city))
        .header(firstHeaderName, firstHeaderValue)
        .header(secondHeaderName, API_Key)
        .asString();

    return objectMapper.readValue(response.getBody(), PlaceList.class);
  }
}
