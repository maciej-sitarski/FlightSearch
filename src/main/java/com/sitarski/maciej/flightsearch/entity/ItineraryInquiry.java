package com.sitarski.maciej.flightsearch.entity;

import java.time.LocalDate;
import java.util.Date;

public class ItineraryInquiry {

  private String originPlace;
  private String destinationPlace;
  private LocalDate outboundDate;
  private LocalDate inboundDate;
  private String transportClass;
  private Integer numOfAdults;
  private Integer numOfChildren;
  private Integer numOfInfants;

  public static final class Builder {

    private String originPlace;
    private String destinationPlace;
    private LocalDate outboundDate;
    private LocalDate inboundDate;
    private String transportClass;
    private Integer numOfAdults;
    private Integer numOfChildren;
    private Integer numOfInfants;

    public Builder originPlace(String originPlace) {
      this.originPlace = originPlace;
      return this;
    }

    public Builder destinationPlace(String destinationPlace) {
      this.destinationPlace = destinationPlace;
      return this;
    }

    public Builder outboundDate(LocalDate outboundDate) {
      this.outboundDate = outboundDate;
      return this;
    }

    public Builder inboundDate(LocalDate inboundDate) {
      this.inboundDate = inboundDate;
      return this;
    }

    public Builder transportClass(String transportClass) {
      this.transportClass = transportClass;
      return this;
    }

    public Builder numOfAdults(Integer numOfAdults) {
      this.numOfAdults = numOfAdults;
      return this;
    }

    public Builder numOfChildren(Integer numOfChildren) {
      this.numOfChildren = numOfChildren;
      return this;
    }

    public Builder numOfInfants(Integer numOfInfants) {
      this.numOfInfants = numOfInfants;
      return this;
    }

    public ItineraryInquiry build() {
      ItineraryInquiry itineraryInquiry = new ItineraryInquiry();
      itineraryInquiry.originPlace = this.originPlace;
      itineraryInquiry.destinationPlace = this.destinationPlace;
      itineraryInquiry.outboundDate = this.outboundDate;
      itineraryInquiry.inboundDate = this.inboundDate;
      itineraryInquiry.transportClass = this.transportClass;
      itineraryInquiry.numOfAdults = this.numOfAdults;
      itineraryInquiry.numOfChildren = this.numOfChildren;
      itineraryInquiry.numOfInfants = this.numOfInfants;
      return itineraryInquiry;
    }
  }

  @Override
  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();
    if (inboundDate != null) {
      stringBuilder.append("inboundDate=");
      stringBuilder.append(inboundDate);
      stringBuilder.append("&");
    }
    stringBuilder.append("cabinClass=");
    stringBuilder.append(transportClass);
    stringBuilder.append("&children=");
    stringBuilder.append(numOfChildren);
    stringBuilder.append("&infants=");
    stringBuilder.append(numOfInfants);
    stringBuilder.append("&country=PL&currency=PLN&locale=pl-US&originPlace=");
    stringBuilder.append(originPlace);
    stringBuilder.append("-sky&destinationPlace=");
    stringBuilder.append(destinationPlace);
    stringBuilder.append("-sky&outboundDate=");
    stringBuilder.append(outboundDate);
    stringBuilder.append("&adults=");
    stringBuilder.append(numOfAdults);
    return stringBuilder.toString();
  }
}
