package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CarrierApi {

  @JsonProperty("Id")
  private Long id;

  @JsonProperty("Code")
  private String code;

  @JsonProperty("Name")
  private String name;

  @JsonProperty("ImageUrl")
  private String imageUrl;

  @JsonProperty("DisplayCode")
  private String displayCode;
}
