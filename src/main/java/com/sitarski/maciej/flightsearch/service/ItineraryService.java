package com.sitarski.maciej.flightsearch.service;

import com.sitarski.maciej.flightsearch.dao.ItineraryRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItineraryService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private final ItineraryRepository itineraryRepository;

  @Autowired
  public ItineraryService(
      ItineraryRepository itineraryRepository) {
    this.itineraryRepository = itineraryRepository;
  }

  public Itinerary findItineraryByClientNumber(String clientStringNumber){
    Long clientNumber = Long.valueOf(clientStringNumber);
    return itineraryRepository.findByClientNumber(clientNumber).orElse(null);
  }
}
