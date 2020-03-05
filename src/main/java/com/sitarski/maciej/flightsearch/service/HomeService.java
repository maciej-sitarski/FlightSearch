package com.sitarski.maciej.flightsearch.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

  private final PlaceService placeService;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  public HomeService(PlaceService placeService) {
    this.placeService = placeService;
  }


  public List<String> getAutocompletePlacesList(String place) throws IOException, UnirestException {
    logger.info("Get autocomplete place list");
    return placeService.getSelectedAutocompletePlacesList(place);
  }
}
