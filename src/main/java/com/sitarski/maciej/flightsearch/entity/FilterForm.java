package com.sitarski.maciej.flightsearch.entity;

import lombok.Data;

@Data
public class FilterForm {

  private String clientNumber;
  private String direct;
  private String oneStop;
  private String moreStops;
  private String outboundTimeFrom;
  private String outboundTimeTo;
  private String duration;
  private String sortOrder;


}
