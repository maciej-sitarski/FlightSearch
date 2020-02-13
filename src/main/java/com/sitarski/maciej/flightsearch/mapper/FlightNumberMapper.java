package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.dao.CarrierRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Carrier;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.FlightNumber;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.FlightNumberApi;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightNumberMapper {

  private final CarrierRepository carrierRepository;

  @Autowired
  public FlightNumberMapper(
      CarrierRepository carrierRepository) {
    this.carrierRepository = carrierRepository;
  }

  public FlightNumber mapFlightNumberApiToEntity(FlightNumberApi flightNumberApi) {

    Optional<FlightNumberApi> flightNumberApiOptional = Optional.ofNullable(flightNumberApi);
    FlightNumber flightNumber = new FlightNumber();

    String flightNumberDetail = flightNumberApiOptional
        .map(FlightNumberApi::getFlightNumber)
        .orElse(null);

    Carrier carrier = Objects.requireNonNull(flightNumberApiOptional
        .map(FlightNumberApi::getCarrierId)
        .map(carrierRepository::findByCarrierId)
        .orElse(null))
        .orElse(null);

    flightNumber.setCarrier(carrier);
    flightNumber.setFlightNumber(flightNumberDetail);

    return flightNumber;
  }
}
