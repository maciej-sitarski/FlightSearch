package com.sitarski.maciej.flightsearch.entity.LiveFlightSearch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "segment")
public class Segment {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "segment_id")
  private Long segmentId;

  @Column(name = "originStation")
  private Long originStation;

  @Column(name = "destinationStation")
  private Long destinationStation;

  @Column(name = "departureDateTime")
  private String departureDateTime;

  @Column(name = "arrivalDateTime")
  private String arrivalDateTime;

  @Column(name = "carrierId")
  private Long carrierId;

  @Column(name = "operatingCarrierId")
  private Long operatingCarrierId;

  @Column(name = "duration")
  private Long duration;

  @Column(name = "flightNumber")
  private String flightNumber;

  @Column(name = "directionality")
  private String directionality;

  @ManyToOne
  @JoinColumn(name = "itinerary_id")
  private Itinerary itinerary;

  public Segment() {
  }

  public Segment(Long segmentId, Long originStation, Long destinationStation,
      String departureDateTime, String arrivalDateTime, Long carrierId,
      Long operatingCarrierId, Long duration, String flightNumber, String directionality) {
    this.segmentId = segmentId;
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

  public Long getSegmentId() {
    return segmentId;
  }

  public void setSegmentId(Long segmentId) {
    this.segmentId = segmentId;
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

  public Itinerary getItinerary() {
    return itinerary;
  }

  public void setItinerary(Itinerary itinerary) {
    this.itinerary = itinerary;
  }
}
