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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "leg")
public class Leg {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "legId")
  private String legId;

  @Column(name = "originStation")
  private Long originStation;

  @Column(name = "destinationStation")
  private Long destinationStation;

  @Column(name = "departure")
  private String departure;

  @Column(name = "arrival")
  private String arrival;

  @Column(name = "duration")
  private Long duration;

  @Column(name = "journeyMode")
  private String journeyMode;

  @Column(name = "directionality")
  private String directionality;

  @OneToMany(mappedBy = "leg", cascade = CascadeType.ALL)
  private List<FlightNumber> flightNumbers = new ArrayList<>();

  @ManyToMany(mappedBy = "legs", cascade = CascadeType.ALL)
  private List<Carrier> legCarriers;

  @ManyToMany(mappedBy = "legs", cascade = CascadeType.ALL)
  private List<Place> stops;

  @ManyToOne
  @JoinColumn(name = "itinerary_id")
  private Itinerary itinerary;

  public Leg() {
  }

  public Leg(String legId, Long originStation, Long destinationStation, String departure,
      String arrival, Long duration, String journeyMode, String directionality) {
    this.legId = legId;
    this.originStation = originStation;
    this.destinationStation = destinationStation;
    this.departure = departure;
    this.arrival = arrival;
    this.duration = duration;
    this.journeyMode = journeyMode;
    this.directionality = directionality;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public void setFlightNumbers(
      List<FlightNumber> flightNumbers) {
    this.flightNumbers = flightNumbers;
  }

  public Itinerary getItinerary() {
    return itinerary;
  }

  public void setItinerary(Itinerary itinerary) {
    this.itinerary = itinerary;
  }

  public List<Carrier> getLegCarriers() {
    return legCarriers;
  }

  public void setLegCarriers(
      List<Carrier> legCarriers) {
    this.legCarriers = legCarriers;
  }

  public List<Place> getStops() {
    return stops;
  }

  public void setStops(
      List<Place> stops) {
    this.stops = stops;
  }
}
