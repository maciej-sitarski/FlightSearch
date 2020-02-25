package com.sitarski.maciej.flightsearch.jsonApi.jsonPlacesApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties({"CountryId", "RegionId"})
public class Place {

  @JsonProperty("PlaceId")
  private String placeId;

  @JsonProperty("PlaceName")
  private String placeName;

  @JsonProperty("CityId")
  private String cityId;

  @JsonProperty("CountryName")
  private String countryName;
}
