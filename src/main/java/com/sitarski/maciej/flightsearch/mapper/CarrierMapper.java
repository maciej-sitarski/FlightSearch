package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Carrier;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.CarrierApi;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class CarrierMapper {

  public Carrier mapCarrierApiToEntity(CarrierApi carrierApi) {

    Optional<CarrierApi> carrierApiOptional = Optional.ofNullable(carrierApi);
    Carrier carrier = new Carrier();

    carrier.setCarrierId(carrierApiOptional
        .map(CarrierApi::getId)
        .orElse(null));
    carrier.setCode(carrierApiOptional
        .map(CarrierApi::getCode)
        .orElse(null));
    carrier.setDisplayCode(carrierApiOptional
        .map(CarrierApi::getDisplayCode)
        .orElse(null));
    carrier.setImageUrl(carrierApiOptional
        .map(CarrierApi::getImageUrl)
        .orElse(null));
    carrier.setName(carrierApiOptional
        .map(CarrierApi::getName)
        .orElse(null));

    return carrier;
  }
}
