package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FlightNumberApi {

  @JsonProperty("FlightNumber")
  private String flightNumber;

  @JsonProperty("CarrierId")
  private Long carrierId;
}
