package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"JourneyMode"})
public class SegmentApi {

  @JsonProperty("Id")
  private Long id;

  @JsonProperty("OriginStation")
  private Long originStation;

  @JsonProperty("DestinationStation")
  private Long destinationStation;

  @JsonProperty("DepartureDateTime")
  private String  departureDateTime;

  @JsonProperty("ArrivalDateTime")
  private String arrivalDateTime;

  @JsonProperty("Carrier")
  private Long carrierId;

  @JsonProperty("OperatingCarrier")
  private Long operatingCarrierId;

  @JsonProperty("Duration")
  private Long duration;

  @JsonProperty("FlightNumber")
  private String flightNumber;

  @JsonProperty("Directionality")
  private String directionality;

  public SegmentApi() {
  }

  public SegmentApi(Long id, Long originStation, Long destinationStation,
      String departureDateTime, String arrivalDateTime, Long carrierId,
      Long operatingCarrierId, Long duration, String flightNumber, String directionality) {
    this.id = id;
    this.originStation = originStation;
    this.destinationStation = destinationStation;
    this.departureDateTime = departureDateTime;
    this.arrivalDateTime = arrivalDateTime;
    this.carrierId = carrierId;
    this.operatingCarrierId = operatingCarrierId;
    this.duration = duration;
    this.flightNumber = flightNumber;
    this.directionality = directionality;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getOriginStation() {
    return originStation;
  }

  public void setOriginStation(Long originStation) {
    this.originStation = originStation;
  }

  public Long getDestinationStation() {
    return destinationStation;
  }

  public void setDestinationStation(Long destinationStation) {
    this.destinationStation = destinationStation;
  }

  public String getDepartureDateTime() {
    return departureDateTime;
  }

  public void setDepartureDateTime(String departureDateTime) {
    this.departureDateTime = departureDateTime;
  }

  public String getArrivalDateTime() {
    return arrivalDateTime;
  }

  public void setArrivalDateTime(String arrivalDateTime) {
    this.arrivalDateTime = arrivalDateTime;
  }

  public Long getCarrierId() {
    return carrierId;
  }

  public void setCarrierId(Long carrierId) {
    this.carrierId = carrierId;
  }

  public Long getOperatingCarrierId() {
    return operatingCarrierId;
  }

  public void setOperatingCarrierId(Long operatingCarrierId) {
    this.operatingCarrierId = operatingCarrierId;
  }

  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getDirectionality() {
    return directionality;
  }

  public void setDirectionality(String directionality) {
    this.directionality = directionality;
  }
}
