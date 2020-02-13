package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Currency;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.CurrencyApi;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper {

  public Currency mapCurrencyApiToEntity(CurrencyApi currencyApi) {

    Optional<CurrencyApi> currencyApiOptional = Optional.ofNullable(currencyApi);
    Currency currency = new Currency();

    String code = currencyApiOptional
        .map(CurrencyApi::getCode)
        .orElse(null);

    String symbol = currencyApiOptional
        .map(CurrencyApi::getSymbol)
        .orElse(null);

    currency.setCode(code);
    currency.setSymbol(symbol);

    return currency;
  }
}
