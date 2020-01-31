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
@Table(name = "flight_number")
public class FlightNumber {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "flightNumber")
  private String flightNumber;

  @Column(name = "carrierId")
  private Long carrierId;

  @ManyToOne
  @JoinColumn(name = "leg_id")
  private Leg leg;

  public FlightNumber() {
  }

  public FlightNumber(String flightNumber, Long carrierId) {
    this.flightNumber = flightNumber;
    this.carrierId = carrierId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Leg getLeg() {
    return leg;
  }

  public void setLeg(Leg leg) {
    this.leg = leg;
  }
}
