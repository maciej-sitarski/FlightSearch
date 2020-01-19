package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.FlightNumber;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.FlightNumberApi;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class FlightNumberMapper {

  public FlightNumber mapFlightNumberApiToEntity(FlightNumberApi flightNumberApi) {

    Optional<FlightNumberApi> flightNumberApiOptional = Optional.ofNullable(flightNumberApi);
    FlightNumber flightNumber = new FlightNumber();

    flightNumber.setFlightNumber(flightNumberApiOptional
        .map(FlightNumberApi::getFlightNumber)
        .orElse(null));

    flightNumber.setCarrierId(flightNumberApiOptional
        .map(FlightNumberApi::getCarrierId)
        .orElse(null));

    return flightNumber;
  }
}
