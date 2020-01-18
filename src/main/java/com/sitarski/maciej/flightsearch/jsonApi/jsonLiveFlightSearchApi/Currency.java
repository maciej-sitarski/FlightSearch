package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"ThousandsSeparator", "DecimalSeparator", "SymbolOnLeft", "SpaceBetweenAmountAndSymbol", "RoundingCoefficient", "DecimalDigits"})
public class Currency {

  @JsonProperty("Code")
  private String code;

  @JsonProperty("Symbol")
  private String symbol;

  public Currency() {
  }

  public Currency(String code, String symbol) {
    this.code = code;
    this.symbol = symbol;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }
}
