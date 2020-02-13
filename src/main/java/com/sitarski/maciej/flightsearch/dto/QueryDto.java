package com.sitarski.maciej.flightsearch.dto;

import lombok.Data;

@Data
public class QueryDto {

  private String originPlace;
  private String destinationPlace;
  private String outboundDate;
  private String inboundDate;
  private String cabinClass;
  private Long adults;
  private Long children;
  private Long infants;
}
