package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {

  @JsonProperty("Code")
  private String code;

  @JsonProperty("Symbol")
  private String symbol;

  @JsonProperty("ThousandsSeparator")
  private String thousandsSeparator;

  @JsonProperty("DecimalSeparator")
  private String decimalSeparator;

  @JsonProperty("SymbolOnLeft")
  private Boolean symbolOnLeft;

  @JsonProperty("SpaceBetweenAmountAndSymbol")
  private Boolean spaceBetweenAmountAndSymbol;

  @JsonProperty("RoundingCoefficient")
  private Long roundingCoefficient;

  @JsonProperty("DecimalDigits")
  private Long decimalDigits;

  public Currency() {
  }

  public Currency(String code, String symbol, String thousandsSeparator,
      String decimalSeparator, Boolean symbolOnLeft, Boolean spaceBetweenAmountAndSymbol,
      Long roundingCoefficient, Long decimalDigits) {
    this.code = code;
    this.symbol = symbol;
    this.thousandsSeparator = thousandsSeparator;
    this.decimalSeparator = decimalSeparator;
    this.symbolOnLeft = symbolOnLeft;
    this.spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
    this.roundingCoefficient = roundingCoefficient;
    this.decimalDigits = decimalDigits;
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

  public String getThousandsSeparator() {
    return thousandsSeparator;
  }

  public void setThousandsSeparator(String thousandsSeparator) {
    this.thousandsSeparator = thousandsSeparator;
  }

  public String getDecimalSeparator() {
    return decimalSeparator;
  }

  public void setDecimalSeparator(String decimalSeparator) {
    this.decimalSeparator = decimalSeparator;
  }

  public Boolean getSymbolOnLeft() {
    return symbolOnLeft;
  }

  public void setSymbolOnLeft(Boolean symbolOnLeft) {
    this.symbolOnLeft = symbolOnLeft;
  }

  public Boolean getSpaceBetweenAmountAndSymbol() {
    return spaceBetweenAmountAndSymbol;
  }

  public void setSpaceBetweenAmountAndSymbol(Boolean spaceBetweenAmountAndSymbol) {
    this.spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
  }

  public Long getRoundingCoefficient() {
    return roundingCoefficient;
  }

  public void setRoundingCoefficient(Long roundingCoefficient) {
    this.roundingCoefficient = roundingCoefficient;
  }

  public Long getDecimalDigits() {
    return decimalDigits;
  }

  public void setDecimalDigits(Long decimalDigits) {
    this.decimalDigits = decimalDigits;
  }
}
