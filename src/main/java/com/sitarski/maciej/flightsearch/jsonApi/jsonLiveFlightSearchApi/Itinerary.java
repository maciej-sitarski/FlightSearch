package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class Itinerary {

  @JsonProperty("SessionKey")
  private String sessionKey;

  @JsonProperty("Status")
  private String status;

  @JsonProperty("Query")
  private Query query;

  @JsonProperty("Itineraries")
  private List<ItineraryDetail> itineraryDetail;

  @JsonProperty("Legs")
  private List<Leg> leg;

  @JsonProperty("Segments")
  private List<Segment> segment;

  @JsonProperty("Carriers")
  private List<Carrier> carrier;

  @JsonProperty("Agents")
  private List<Agent> agent;

  @JsonProperty("Places")
  private List<Place> place;

  @JsonProperty("Currencies")
  private List<Currency> currency;

  public Itinerary() {
  }

  public Itinerary(String sessionKey, String status, Query query,
      List<ItineraryDetail> itineraryDetail, List<Leg> leg, List<Segment> segment,
      List<Carrier> carrier, List<Agent> agent, List<Place> place,
      List<Currency> currency) {
    this.sessionKey = sessionKey;
    this.status = status;
    this.query = query;
    this.itineraryDetail = itineraryDetail;
    this.leg = leg;
    this.segment = segment;
    this.carrier = carrier;
    this.agent = agent;
    this.place = place;
    this.currency = currency;
  }

  public String getSessionKey() {
    return sessionKey;
  }

  public void setSessionKey(String sessionKey) {
    this.sessionKey = sessionKey;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Query getQuery() {
    return query;
  }

  public void setQuery(Query query) {
    this.query = query;
  }

  public List<ItineraryDetail> getItineraryDetail() {
    return itineraryDetail;
  }

  public void setItineraryDetail(List<ItineraryDetail> itineraryDetail) {
    this.itineraryDetail = itineraryDetail;
  }

  public List<Leg> getLeg() {
    return leg;
  }

  public void setLeg(List<Leg> leg) {
    this.leg = leg;
  }

  public List<Segment> getSegment() {
    return segment;
  }

  public void setSegment(List<Segment> segment) {
    this.segment = segment;
  }

  public List<Carrier> getCarrier() {
    return carrier;
  }

  public void setCarrier(List<Carrier> carrier) {
    this.carrier = carrier;
  }

  public List<Agent> getAgent() {
    return agent;
  }

  public void setAgent(List<Agent> agent) {
    this.agent = agent;
  }

  public List<Place> getPlace() {
    return place;
  }

  public void setPlace(List<Place> place) {
    this.place = place;
  }

  public List<Currency> getCurrency() {
    return currency;
  }

  public void setCurrency(List<Currency> currency) {
    this.currency = currency;
  }
}
