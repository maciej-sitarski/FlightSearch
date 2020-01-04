package com.sitarski.maciej.flightsearch.jsonApi.jsonPlacesApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PlaceList {

  @JsonProperty("Places")
  private List<Place> places;

  public PlaceList() {
  }

  public PlaceList(List<Place> places) {
    this.places = places;
  }

  public List<Place> getPlaces() {
    return places;
  }

  public void setPlaces(List<Place> places) {
    this.places = places;
  }
}
