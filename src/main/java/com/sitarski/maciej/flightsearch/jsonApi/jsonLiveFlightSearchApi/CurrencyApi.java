package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties({"ThousandsSeparator", "DecimalSeparator", "SymbolOnLeft", "SpaceBetweenAmountAndSymbol", "RoundingCoefficient", "DecimalDigits"})
public class CurrencyApi {

  @JsonProperty("Code")
  private String code;

  @JsonProperty("Symbol")
  private String symbol;
}
