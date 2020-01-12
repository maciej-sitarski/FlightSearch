package com.sitarski.maciej.flightsearch.parser;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.entity.ItineraryInquiry;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.Itinerary;
import com.sitarski.maciej.flightsearch.service.StringFormatService;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class LiveFlightSearchParserTest {

  @Test
  void parseItinerary() throws InterruptedException, UnirestException, IOException {

    //given
    LocalDate today = LocalDate.now();
    String tomorrow = today.plusDays(1).toString();
    ItineraryInquiry itineraryInquiry = new ItineraryInquiry.Builder()
        .originPlace("GDN")
        .destinationPlace("WAW")
        .outboundDate(tomorrow)
        .inboundDate(null)
        .transportClass("economy")
        .numOfAdults("1")
        .numOfChildren("0")
        .numOfInfants("0")
        .build();
    StringFormatService stringFormatService = new StringFormatService();
    LiveFlightSearchParser liveFlightSearchParser = new LiveFlightSearchParser(stringFormatService);

    //when
    Itinerary itinerary = liveFlightSearchParser.parseItinerary(itineraryInquiry);

    //then
    Assert.assertEquals("1", itinerary.getQuery().getAdults().toString());
    Assert.assertEquals("economy", itinerary.getQuery().getCabinClass());
    Assert.assertEquals(tomorrow, itinerary.getQuery().getOutboundDate());
  }
}