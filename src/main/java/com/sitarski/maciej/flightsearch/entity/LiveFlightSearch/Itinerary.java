package com.sitarski.maciej.flightsearch.entity.LiveFlightSearch;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="itinerary")
public class Itinerary {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "sessionKey")
  private String sessionKey;

  @Column(name = "status")
  private String status;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "query_id", unique = true)
  private Query query;

  @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
  private List<ItineraryDetail> itineraryDetail = new ArrayList<>();

  @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
  private List<Leg> leg = new ArrayList<>();

  @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
  private List<Segment> segment = new ArrayList<>();

  @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
  private List<Carrier> carrier = new ArrayList<>();

  @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
  private List<Agent> agent = new ArrayList<>();

  @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
  private List<Place> place = new ArrayList<>();

  @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
  private List<Currency> currency = new ArrayList<>();

  public Itinerary() {
  }

  public Itinerary(String sessionKey, String status) {
    this.sessionKey = sessionKey;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public void setItineraryDetail(
      List<ItineraryDetail> itineraryDetail) {
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

  public void setSegment(
      List<Segment> segment) {
    this.segment = segment;
  }

  public List<Carrier> getCarrier() {
    return carrier;
  }

  public void setCarrier(
      List<Carrier> carrier) {
    this.carrier = carrier;
  }

  public List<Agent> getAgent() {
    return agent;
  }

  public void setAgent(
      List<Agent> agent) {
    this.agent = agent;
  }

  public List<Place> getPlace() {
    return place;
  }

  public void setPlace(
      List<Place> place) {
    this.place = place;
  }

  public List<Currency> getCurrency() {
    return currency;
  }

  public void setCurrency(
      List<Currency> currency) {
    this.currency = currency;
  }
}
