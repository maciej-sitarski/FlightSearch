package com.sitarski.maciej.flightsearch.jsonApi.jsonPlacesApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties({"ValidationErrors"})
public class PlaceList {

  @JsonProperty("Places")
  private List<Place> places;
}
