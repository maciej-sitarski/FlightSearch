package com.sitarski.maciej.flightsearch.entity;

import lombok.Data;

@Data
public class SearchForm {
  private String originPlace;
  private String destinationPlace;
  private String outboundDate;
  private String inboundDate;
  private String transportClass;
  private String numberOfAdults;
  private String numberOfChildren;
  private String numberOfInfants;

}
