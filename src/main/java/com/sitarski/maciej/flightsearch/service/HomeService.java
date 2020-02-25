package com.sitarski.maciej.flightsearch.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

  private final PlaceService placeService;

  @Autowired
  public HomeService(PlaceService placeService) {
    this.placeService = placeService;
  }


  public List<String> getAutocompletePlacesList(String place) throws IOException, UnirestException {
    return placeService.getSelectedAutocompletePlacesList(place);
  }
}
