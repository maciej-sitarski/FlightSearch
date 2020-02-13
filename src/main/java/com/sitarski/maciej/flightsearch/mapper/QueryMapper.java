package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Query;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.QueryApi;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class QueryMapper {

  public Query mapQueryApiToEntity(QueryApi queryApi) {

    Optional<QueryApi> queryApiOptional = Optional.ofNullable(queryApi);
    Query query = new Query();

    Long adults = queryApiOptional
        .map(QueryApi::getAdults)
        .orElse(null);

    String cabinClass = queryApiOptional
        .map(QueryApi::getCabinClass)
        .orElse(null);

    Long children = queryApiOptional
        .map(QueryApi::getChildren)
        .orElse(null);

    String country = queryApiOptional
        .map(QueryApi::getCountry)
        .orElse(null);

    String currency = queryApiOptional
        .map(QueryApi::getCurrency)
        .orElse(null);

    String destinationPlace = queryApiOptional
        .map(QueryApi::getDestinationPlace)
        .orElse(null);

    String inboundDate = queryApiOptional
        .map(QueryApi::getInboundDate)
        .orElse(null);

    String outboundDate = queryApiOptional
        .map(QueryApi::getOutboundDate)
        .orElse(null);

    Long infants = queryApiOptional
        .map(QueryApi::getInfants)
        .orElse(null);

    String originPlace = queryApiOptional
        .map(QueryApi::getOriginPlace)
        .orElse(null);

    String locale = queryApiOptional
        .map(QueryApi::getLocale)
        .orElse(null);

    query.setAdults(adults);
    query.setCabinClass(cabinClass);
    query.setChildren(children);
    query.setCountry(country);
    query.setCurrency(currency);
    query.setDestinationPlace(destinationPlace);
    query.setInboundDate(inboundDate);
    query.setOutboundDate(outboundDate);
    query.setInfants(infants);
    query.setOriginPlace(originPlace);
    query.setLocale(locale);

    return query;
  }

}
