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

    query.setAdults(queryApiOptional
        .map(QueryApi::getAdults)
        .orElse(null));
    query.setCabinClass(queryApiOptional
        .map(QueryApi::getCabinClass)
        .orElse(null));
    query.setChildren(queryApiOptional
        .map(QueryApi::getChildren)
        .orElse(null));
    query.setCountry(queryApiOptional
        .map(QueryApi::getCountry)
        .orElse(null));
    query.setCurrency(queryApiOptional
        .map(QueryApi::getCurrency)
        .orElse(null));
    query.setDestinationPlace(queryApiOptional
        .map(QueryApi::getDestinationPlace)
        .orElse(null));
    query.setInboundDate(queryApiOptional
        .map(QueryApi::getInboundDate)
        .orElse(null));
    query.setOutboundDate(queryApiOptional
        .map(QueryApi::getOutboundDate)
        .orElse(null));
    query.setInfants(queryApiOptional
        .map(QueryApi::getInfants)
        .orElse(null));
    query.setOriginPlace(queryApiOptional
        .map(QueryApi::getOriginPlace)
        .orElse(null));
    query.setLocale(queryApiOptional
        .map(QueryApi::getLocale)
        .orElse(null));

    return query;
  }

}
