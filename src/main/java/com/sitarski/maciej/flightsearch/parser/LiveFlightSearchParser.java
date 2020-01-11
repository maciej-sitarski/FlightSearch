package com.sitarski.maciej.flightsearch.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.entity.ItineraryInquiry;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.Itinerary;
import com.sitarski.maciej.flightsearch.service.StringFormatService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LiveFlightSearchParser {

  private final StringFormatService stringFormatService;

  @Autowired
  public LiveFlightSearchParser(StringFormatService stringFormatService) {
    this.stringFormatService = stringFormatService;
  }


  private ObjectMapper objectMapper = new ObjectMapper();
  private final String sessionNameFirst = "x-rapidapi-host";
  private final String sessionNameSecond = "x-rapidapi-key";
  private final String sessionValueFirst = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";
  private final String sessionValueSecond = "4a11ecaf22msh48198c7c39b5dc7p12193ejsn07edf2594542";

  public String createSessionKey(ItineraryInquiry itineraryInquiry)
      throws UnirestException, InterruptedException {
    HttpResponse<String> response = createSession(itineraryInquiry);
    Headers headers = response.getHeaders();
    List<String> headerLocation = headers.get("Location");
    String headerLocationValue = headerLocation.get(0);
    return stringFormatService.formatStringLocationHeaderToParse(headerLocationValue);
  }

  public Itinerary parseItinerary(ItineraryInquiry itineraryInquiry)
      throws UnirestException, IOException, InterruptedException {
    String sessionKey = createSessionKey(itineraryInquiry);

    HttpResponse<String> response = Unirest.get(String.format(
        "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/uk2/v1.0/%s?sortType=outbounddeparttime&sortOrder=asc",
        sessionKey))
        .header(sessionNameFirst, sessionValueFirst)
        .header(sessionNameSecond, sessionValueSecond)
        .asString();
    return objectMapper.readValue(response.getBody(), Itinerary.class);
  }

  private HttpResponse<String> createSession(ItineraryInquiry itineraryInquiry)
      throws UnirestException, InterruptedException {
    String sessionNameThird = "content-type";
    String sessionValueThird = "application/x-www-form-urlencoded";
    String bodyContent = itineraryInquiry.toString();

    HttpResponse<String> response = null;
    do {
      if (response != null) {
        Thread.sleep(5000);
      }
      response = Unirest.post(
          "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0")
          .header(sessionNameFirst, sessionValueFirst)
          .header(sessionNameSecond, sessionValueSecond)
          .header(sessionNameThird, sessionValueThird)
          .body(bodyContent)
          .asString();
    } while (response.getStatus() < 200 || response.getStatus() > 300);

    return response;
  }
}
