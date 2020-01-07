package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"Locale", "LocationSchema"})
public class Query {

  @JsonProperty("Country")
  private String country;

  @JsonProperty("Currency")
  private String currency;

  @JsonProperty("Adults")
  private Long adults;

  @JsonProperty("Children")
  private Long children;

  @JsonProperty("Infants")
  private Long infants;

  @JsonProperty("OriginPlace")
  private String originPlace;

  @JsonProperty("DestinationPlace")
  private String destinationPlace;

  @JsonProperty("OutboundDate")
  private String outboundDate;

  @JsonProperty("InboundDate")
  private String inboundDate;

  @JsonProperty("CabinClass")
  private String cabinClass;

  @JsonProperty("GroupPricing")
  private Boolean groupPricing;

  public Query() {
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

  public Boolean getGroupPricing() {
    return groupPricing;
  }

  public void setGroupPricing(Boolean groupPricing) {
    this.groupPricing = groupPricing;
  }
}
