package com.sitarski.maciej.flightsearch.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dao.ItineraryRepository;
import com.sitarski.maciej.flightsearch.entity.ItineraryInquiry;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.SearchForm;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.ItineraryApi;
import com.sitarski.maciej.flightsearch.parser.LiveFlightSearchParser;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItineraryService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private final ItineraryRepository itineraryRepository;
  private final StringFormatService stringFormatService;
  private final LiveFlightSearchParser liveFlightSearchParser;

  @Autowired
  public ItineraryService(
      ItineraryRepository itineraryRepository,
      StringFormatService stringFormatService,
      LiveFlightSearchParser liveFlightSearchParser) {
    this.itineraryRepository = itineraryRepository;
    this.stringFormatService = stringFormatService;
    this.liveFlightSearchParser = liveFlightSearchParser;
  }

  public Itinerary findItineraryByClientNumber(String clientStringNumber){
    logger.info("Find itinerary by client number");
    Long clientNumber = Long.valueOf(clientStringNumber);
    return itineraryRepository.findByClientNumber(clientNumber).orElse(null);
  }

  private ItineraryInquiry getItineraryInquiry(SearchForm searchForm){

    String originFormatPlace = stringFormatService.formatStringPlaceToParse(searchForm.getOriginPlace());
    String destinationFormatPlace = stringFormatService.formatStringPlaceToParse(searchForm.getDestinationPlace());

    return new ItineraryInquiry.Builder()
        .originPlace(originFormatPlace)
        .destinationPlace(destinationFormatPlace)
        .outboundDate(searchForm.getOutboundDate())
        .inboundDate(searchForm.getInboundDate())
        .transportClass(searchForm.getTransportClass())
        .numOfAdults(searchForm.getNumberOfAdults())
        .numOfChildren(searchForm.getNumberOfChildren())
        .numOfInfants(searchForm.getNumberOfInfants())
        .build();
  }

  ItineraryApi getItineraryApi(SearchForm searchForm)
      throws InterruptedException, IOException, UnirestException {
    ItineraryInquiry itineraryInquiry = getItineraryInquiry(searchForm);
    ItineraryApi itineraryApi = null;
    do {
      if (itineraryApi != null) {
        Thread.sleep(1000);
      }
      itineraryApi = liveFlightSearchParser.parseItinerary(itineraryInquiry);
    } while (itineraryApi.getItineraryDetailApi() == null || itineraryApi.getItineraryDetailApi()
        .isEmpty());

    return itineraryApi;
  }
}
