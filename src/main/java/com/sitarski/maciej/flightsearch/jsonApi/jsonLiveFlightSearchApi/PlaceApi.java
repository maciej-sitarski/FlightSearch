package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonProperty;

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

  public PlaceApi() {
  }

  public PlaceApi(Long id, Long parentId, String code, String type, String name) {
    this.id = id;
    this.parentId = parentId;
    this.code = code;
    this.type = type;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
