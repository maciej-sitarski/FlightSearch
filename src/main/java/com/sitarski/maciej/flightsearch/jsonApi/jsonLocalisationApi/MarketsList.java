package com.sitarski.maciej.flightsearch.jsonApi.jsonLocalisationApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MarketsList {

  @JsonProperty("Places")
  private List<Market> markets;

  public MarketsList() {
  }

  public MarketsList(List<Market> markets) {
    this.markets = markets;
  }

  public List<Market> getMarkets() {
    return markets;
  }

  public void setMarkets(List<Market> markets) {
    this.markets = markets;
  }
}
