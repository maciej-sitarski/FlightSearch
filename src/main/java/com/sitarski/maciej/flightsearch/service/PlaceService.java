package com.sitarski.maciej.flightsearch.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.jsonApi.jsonPlacesApi.PlaceList;
import com.sitarski.maciej.flightsearch.parser.PlaceParser;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

  private final PlaceParser placeParser;
  private final StringFormatService stringFormatService;

  @Autowired
  public PlaceService(PlaceParser placeParser,
      StringFormatService stringFormatService) {
    this.placeParser = placeParser;
    this.stringFormatService = stringFormatService;
  }

  public List<String> getSelectedAutocompletePlacesList(String place)
      throws IOException, UnirestException {
    PlaceList placeList = placeParser.parsePlaces(place);
    return  placeList.getPlaces()
        .stream()
        .filter(place1 -> !place1.getCityId().equals("-sky"))
        .filter(place1 -> place1.getPlaceName().toLowerCase().contains(place.toLowerCase()) || place1.getPlaceId().toLowerCase().contains(place.toLowerCase()))
        .map(place1 -> String.format("%s(%s)", place1.getPlaceName(),
            stringFormatService.formatStringPlace(place1.getPlaceId())))
        .collect(Collectors.toList());
  }

}
