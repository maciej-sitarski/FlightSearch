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
@Table(name = "currency")
public class Currency {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "code")
  private String code;

  @Column(name = "symbol")
  private String symbol;

  @ManyToOne
  @JoinColumn(name = "itinerary_id")
  private Itinerary itinerary;

  public Currency() {
  }

  public Currency(String code, String symbol) {
    this.code = code;
    this.symbol = symbol;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public Itinerary getItinerary() {
    return itinerary;
  }

  public void setItinerary(Itinerary itinerary) {
    this.itinerary = itinerary;
  }
}
