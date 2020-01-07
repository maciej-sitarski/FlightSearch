package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties({"SegmentIds", "Stops", "Carriers", "OperatingCarriers"})
public class Leg {

  @JsonProperty("Id")
  private String legId;

  @JsonProperty("OriginStation")
  private Long originStation;

  @JsonProperty("DestinationStation")
  private Long destinationStation;

  @JsonProperty("Departure")
  private String departure;

  @JsonProperty("Arrival")
  private String arrival;

  @JsonProperty("Duration")
  private Long duration;

  @JsonProperty("JourneyMode")
  private String journeyMode;

  @JsonProperty("Directionality")
  private String directionality;

  @JsonProperty("FlightNumbers")
  private List<FlightNumber> flightNumbers;

  public Leg() {
  }

  public Leg(String legId, Long originStation, Long destinationStation, String departure,
      String arrival, Long duration, String journeyMode, String directionality,
      List<FlightNumber> flightNumbers) {
    this.legId = legId;
    this.originStation = originStation;
    this.destinationStation = destinationStation;
    this.departure = departure;
    this.arrival = arrival;
    this.duration = duration;
    this.journeyMode = journeyMode;
    this.directionality = directionality;
    this.flightNumbers = flightNumbers;
  }

  public String getLegId() {
    return legId;
  }

  public void setLegId(String legId) {
    this.legId = legId;
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

  public String getDeparture() {
    return departure;
  }

  public void setDeparture(String departure) {
    this.departure = departure;
  }

  public String getArrival() {
    return arrival;
  }

  public void setArrival(String arrival) {
    this.arrival = arrival;
  }

  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }

  public String getJourneyMode() {
    return journeyMode;
  }

  public void setJourneyMode(String journeyMode) {
    this.journeyMode = journeyMode;
  }

  public String getDirectionality() {
    return directionality;
  }

  public void setDirectionality(String directionality) {
    this.directionality = directionality;
  }

  public List<FlightNumber> getFlightNumbers() {
    return flightNumbers;
  }

  public void setFlightNumbers(List<FlightNumber> flightNumbers) {
    this.flightNumbers = flightNumbers;
  }
}
