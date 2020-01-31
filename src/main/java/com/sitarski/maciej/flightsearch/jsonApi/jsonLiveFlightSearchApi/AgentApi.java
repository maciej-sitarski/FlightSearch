package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonProperty;

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

  public AgentApi() {
  }

  public AgentApi(Long id, String name, String imageUrl, String status,
      Boolean optimisedForMobile, String type) {
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.status = status;
    this.optimisedForMobile = optimisedForMobile;
    this.type = type;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Boolean getOptimisedForMobile() {
    return optimisedForMobile;
  }

  public void setOptimisedForMobile(Boolean optimisedForMobile) {
    this.optimisedForMobile = optimisedForMobile;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
