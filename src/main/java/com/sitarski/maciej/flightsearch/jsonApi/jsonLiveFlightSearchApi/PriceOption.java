package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties({"QuoteAgeInMinutes"})
public class PriceOption {

  @JsonProperty("Agents")
  private List<Long> agents;

  @JsonProperty("Price")
  private Float price;

  @JsonProperty("DeeplinkUrl")
  private String linkUrl;

  public PriceOption() {
  }

  public PriceOption(List<Long> agents, Float price, String linkUrl) {
    this.agents = agents;
    this.price = price;
    this.linkUrl = linkUrl;
  }

  public List<Long> getAgents() {
    return agents;
  }

  public void setAgents(List<Long> agents) {
    this.agents = agents;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getLinkUrl() {
    return linkUrl;
  }

  public void setLinkUrl(String linkUrl) {
    this.linkUrl = linkUrl;
  }
}
