package com.sitarski.maciej.flightsearch.jsonApi.jsonLocalisationApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Market {

  @JsonProperty("Code")
  private String code;

  @JsonProperty("Name")
  private String name;

  public Market() {
  }

  public Market(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
