package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.ItineraryDetail;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.PriceOption;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.ItineraryDetailApi;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItineraryDetailMapper {

  @Autowired
  PriceOptionMapper priceOptionMapper;

  public ItineraryDetail mapItineraryDetailApiToEntity(ItineraryDetailApi itineraryDetailApi) {

    Optional<ItineraryDetailApi> itineraryDetailApiOptional = Optional.ofNullable(itineraryDetailApi);
    ItineraryDetail itineraryDetail = new ItineraryDetail();

    itineraryDetail.setInboundLegId(itineraryDetailApiOptional
        .map(ItineraryDetailApi::getInboundLegId)
        .orElse(null));
    itineraryDetail.setOutboundLegId(itineraryDetailApiOptional
        .map(ItineraryDetailApi::getOutboundLegId)
        .orElse(null));

    List<PriceOption> priceOptions = itineraryDetailApiOptional
        .map(ItineraryDetailApi::getPriceOptionApis)
        .orElse(Collections.emptyList())
        .stream()
        .map(priceOptionMapper::mapPriceOptionApiToEntity)
        .collect(Collectors.toList());
    itineraryDetail.setPriceOptions(priceOptions);

    return itineraryDetail;
  }
}
