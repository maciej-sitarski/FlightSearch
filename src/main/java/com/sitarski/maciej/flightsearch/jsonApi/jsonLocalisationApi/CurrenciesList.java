package com.sitarski.maciej.flightsearch.jsonApi.jsonLocalisationApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CurrenciesList {

  @JsonProperty("Currencies")
  private List<List<Currency>> currencies;

  public CurrenciesList() {
  }

  public CurrenciesList(List<List<Currency>> currencies) {
    this.currencies = currencies;
  }

  public List<List<Currency>> getCurrencies() {
    return currencies;
  }

  public void setCurrencies(List<List<Currency>> currencies) {
    this.currencies = currencies;
  }
}
