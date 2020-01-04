package com.sitarski.maciej.flightsearch.jsonApi.jsonLocalisationApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CurrenciesList {

  @JsonProperty("Currencies")
  private List<Currency> currencies;

  public CurrenciesList() {
  }

  public CurrenciesList(List<Currency> currencies) {
    this.currencies = currencies;
  }

  public List<Currency> getCurrencies() {
    return currencies;
  }

  public void setCurrencies(List<Currency> currencies) {
    this.currencies = currencies;
  }
}
