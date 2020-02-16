package com.sitarski.maciej.flightsearch.dto;

import lombok.Data;

@Data
public class InformationCardDto {

  private String outboundDate;
  private String inboundDate;
  private String cabinClass;
  private Long adults;
  private Long children;
  private Long infants;
}
