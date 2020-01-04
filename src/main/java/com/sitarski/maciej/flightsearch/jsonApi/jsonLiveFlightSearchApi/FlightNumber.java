package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightNumber {

  @JsonProperty("FlightNumber")
  private String flightNumber;

  @JsonProperty("CarrierId")
  private String carrierId;

  public FlightNumber() {
  }

  public FlightNumber(String flightNumber, String carrierId) {
    this.flightNumber = flightNumber;
    this.carrierId = carrierId;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getCarrierId() {
    return carrierId;
  }

  public void setCarrierId(String carrierId) {
    this.carrierId = carrierId;
  }
}
