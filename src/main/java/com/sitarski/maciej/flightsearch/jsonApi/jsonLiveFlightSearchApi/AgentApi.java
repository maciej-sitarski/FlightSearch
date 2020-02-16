package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AgentApi {

  @JsonProperty("Id")
  private Long id;

  @JsonProperty("Name")
  private String name;

  @JsonProperty("ImageUrl")
  private String imageUrl;

  @JsonProperty("Status")
  private String status;

  @JsonProperty("OptimisedForMobile")
  private Boolean optimisedForMobile;

  @JsonProperty("Type")
  private String type;
}
