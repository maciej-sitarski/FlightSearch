package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Carrier {

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

  public Carrier() {
  }

  public Carrier(Long id, String code, String name, String imageUrl, String displayCode) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.imageUrl = imageUrl;
    this.displayCode = displayCode;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getDisplayCode() {
    return displayCode;
  }

  public void setDisplayCode(String displayCode) {
    this.displayCode = displayCode;
  }
}
