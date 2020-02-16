package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PlaceApi {

  @JsonProperty("Id")
  private Long id;

  @JsonProperty("ParentId")
  private Long parentId;

  @JsonProperty("Code")
  private String code;

  @JsonProperty("Type")
  private String type;

  @JsonProperty("Name")
  private String name;
}
