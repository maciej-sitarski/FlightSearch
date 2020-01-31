package com.sitarski.maciej.flightsearch.parser;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLocalisationApi.Currency;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLocalisationApi.Market;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class LocalisationParserTest {

  @Test
  void parseMarkets() throws IOException, UnirestException {

    //given
    LocalisationParser localisationParser = new LocalisationParser();

    //when
    List<Market> marketsList = localisationParser.parseMarkets().getMarkets().get(1);

    List<Market> marketFinal = marketsList.stream().filter(market -> market.getCode().equals("PL"))
        .collect(
            Collectors.toList());
    //then
    Assert.assertEquals("PL", marketFinal.get(0).getCode());

  }

  @Test
  void parseCurrencies() throws IOException, UnirestException {

    //given
    LocalisationParser localisationParser = new LocalisationParser();

    //when
    List<Currency> currenciesList = localisationParser.parseCurrencies().getCurrencies().get(0);

    List<Currency> currencyFinal = currenciesList.stream()
        .filter(currency -> currency.getCode().equals("PLN")).collect(
            Collectors.toList());
    //then
    Assert.assertEquals("PLN", currencyFinal.get(0).getCode());
  }
}