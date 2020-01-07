package com.sitarski.maciej.flightsearch.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLocalisationApi.CurrenciesList;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLocalisationApi.MarketsList;
import org.springframework.stereotype.Service;

@Service
public class LocalisationParser {

  private ObjectMapper objectMapper = new ObjectMapper();

  public MarketsList parseMarkets() throws UnirestException, IOException {

    HttpResponse<String> response = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/en-US")
        .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
        .header("x-rapidapi-key", "4a11ecaf22msh48198c7c39b5dc7p12193ejsn07edf2594542")
        .asString();

    JsonNode jsonNode = objectMapper.readTree(String.valueOf(response));
    return objectMapper.readValue(jsonNode.toString(),
        new TypeReference<MarketsList>() {
        });
  }

  public CurrenciesList parseCurrencies() throws UnirestException, IOException {

    HttpResponse<String> response = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/currencies")
        .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
        .header("x-rapidapi-key", "4a11ecaf22msh48198c7c39b5dc7p12193ejsn07edf2594542")
        .asString();

    JsonNode jsonNode = objectMapper.readTree(String.valueOf(response));
    return objectMapper.readValue(jsonNode.toString(),
        new TypeReference<CurrenciesList>() {
        });
  }
}
