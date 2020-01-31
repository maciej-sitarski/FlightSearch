package com.sitarski.maciej.flightsearch.entity.LiveFlightSearch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "query")
public class Query {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "country")
  private String country;

  @Column(name = "currency")
  private String currency;

  @Column(name = "locale")
  private String locale;

  @Column(name = "adults")
  private Long adults;

  @Column(name = "children")
  private Long children;

  @Column(name = "infants")
  private Long infants;

  @Column(name = "originPlace")
  private String originPlace;

  @Column(name = "destinationPlace")
  private String destinationPlace;

  @Column(name = "outboundDate")
  private String outboundDate;

  @Column(name = "inboundDate")
  private String inboundDate;

  @Column(name = "cabinClass")
  private String cabinClass;

  public Query() {
  }

  public Query(String country, String currency, String locale, Long adults, Long children,
      Long infants, String originPlace, String destinationPlace, String outboundDate,
      String inboundDate, String cabinClass) {
    this.country = country;
    this.currency = currency;
    this.locale = locale;
    this.adults = adults;
    this.children = children;
    this.infants = infants;
    this.originPlace = originPlace;
    this.destinationPlace = destinationPlace;
    this.outboundDate = outboundDate;
    this.inboundDate = inboundDate;
    this.cabinClass = cabinClass;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public Long getAdults() {
    return adults;
  }

  public void setAdults(Long adults) {
    this.adults = adults;
  }

  public Long getChildren() {
    return children;
  }

  public void setChildren(Long children) {
    this.children = children;
  }

  public Long getInfants() {
    return infants;
  }

  public void setInfants(Long infants) {
    this.infants = infants;
  }

  public String getOriginPlace() {
    return originPlace;
  }

  public void setOriginPlace(String originPlace) {
    this.originPlace = originPlace;
  }

  public String getDestinationPlace() {
    return destinationPlace;
  }

  public void setDestinationPlace(String destinationPlace) {
    this.destinationPlace = destinationPlace;
  }

  public String getOutboundDate() {
    return outboundDate;
  }

  public void setOutboundDate(String outboundDate) {
    this.outboundDate = outboundDate;
  }

  public String getInboundDate() {
    return inboundDate;
  }

  public void setInboundDate(String inboundDate) {
    this.inboundDate = inboundDate;
  }

  public String getCabinClass() {
    return cabinClass;
  }

  public void setCabinClass(String cabinClass) {
    this.cabinClass = cabinClass;
  }
}
