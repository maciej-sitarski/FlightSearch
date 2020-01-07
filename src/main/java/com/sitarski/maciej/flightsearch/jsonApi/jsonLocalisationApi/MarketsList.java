package com.sitarski.maciej.flightsearch.jsonApi.jsonLocalisationApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MarketsList {

  @JsonProperty("Countries")
  private List<List<Market>> markets;

  public MarketsList() {
  }

  public MarketsList(List<List<Market>> markets) {
    this.markets = markets;
  }

  public List<List<Market>> getMarkets() {
    return markets;
  }

  public void setMarkets(
      List<List<Market>> markets) {
    this.markets = markets;
  }
}
