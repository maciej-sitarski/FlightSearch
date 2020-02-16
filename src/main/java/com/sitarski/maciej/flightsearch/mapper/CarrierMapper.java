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

    Long carrierId = carrierApiOptional
        .map(CarrierApi::getId)
        .orElse(null);

    String code = carrierApiOptional
        .map(CarrierApi::getCode)
        .orElse(null);

    String displayCode = carrierApiOptional
        .map(CarrierApi::getDisplayCode)
        .orElse(null);

    String imageUrl = carrierApiOptional
        .map(CarrierApi::getImageUrl)
        .orElse(null);

    String name = carrierApiOptional
        .map(CarrierApi::getName)
        .orElse(null);

    carrier.setCarrierId(carrierId);
    carrier.setCode(code);
    carrier.setDisplayCode(displayCode);
    carrier.setImageUrl(imageUrl);
    carrier.setName(name);

    return carrier;
  }
}
