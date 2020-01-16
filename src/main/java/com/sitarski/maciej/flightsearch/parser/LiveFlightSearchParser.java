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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LiveFlightSearchParser {

  @Autowired
  public LiveFlightSearchParser(StringFormatService stringFormatService) {
    this.stringFormatService = stringFormatService;
  }

  private final StringFormatService stringFormatService;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private ObjectMapper objectMapper = new ObjectMapper();
  private final String sessionNameFirst = "x-rapidapi-host";
  private final String sessionNameSecond = "x-rapidapi-key";
  private final String sessionValueFirst = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

  @Value("${API_Key}")
  private String API_Key;

  private String createSessionKey(ItineraryInquiry itineraryInquiry)
      throws UnirestException, InterruptedException {

    logger.info("Get session key");

    HttpResponse<String> response = createSession(itineraryInquiry);
    Headers headers = response.getHeaders();
    List<String> headerLocation = headers.get("Location");
    String headerLocationValue = headerLocation.get(0);
    return stringFormatService.formatStringLocationHeaderToParse(headerLocationValue);
  }

  public Itinerary parseItinerary(ItineraryInquiry itineraryInquiry)
      throws UnirestException, IOException, InterruptedException {

    logger.info("Parse response to objects");

    String sessionKey = createSessionKey(itineraryInquiry);

    HttpResponse<String> response = Unirest.get(String.format(
        "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/uk2/v1.0/%s?sortType=outbounddeparttime&sortOrder=asc",
        sessionKey))
        .header(sessionNameFirst, sessionValueFirst)
        .header(sessionNameSecond, API_Key)
        .asString();
    return objectMapper.readValue(response.getBody(), Itinerary.class);
  }

  private HttpResponse<String> createSession(ItineraryInquiry itineraryInquiry)
      throws UnirestException, InterruptedException {

    logger.info("Create session to get live flight search");

    String sessionNameThird = "content-type";
    String sessionValueThird = "application/x-www-form-urlencoded";
    String bodyContent = itineraryInquiry.toString();

    HttpResponse<String> response = null;
    do {
      if (response != null) {
        Thread.sleep(3000);
      }
      response = Unirest.post(
          "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0")
          .header(sessionNameFirst, sessionValueFirst)
          .header(sessionNameSecond, API_Key)
          .header(sessionNameThird, sessionValueThird)
          .body(bodyContent)
          .asString();
    } while (response.getStatus() < 200 || response.getStatus() > 300);
    return response;
  }
}
