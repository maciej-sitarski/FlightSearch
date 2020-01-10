package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightNumber {

  @JsonProperty("FlightNumber")
  private String flightNumber;

  @JsonProperty("CarrierId")
  private Long carrierId;

  public FlightNumber() {
  }

  public FlightNumber(String flightNumber, Long carrierId) {
    this.flightNumber = flightNumber;
    this.carrierId = carrierId;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public Long getCarrierId() {
    return carrierId;
  }

  public void setCarrierId(Long carrierId) {
    this.carrierId = carrierId;
  }
}
