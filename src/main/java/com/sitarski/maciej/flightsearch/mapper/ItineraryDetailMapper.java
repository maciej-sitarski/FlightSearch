package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.dao.LegRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Agent;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.ItineraryDetail;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.PriceOption;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.ItineraryDetailApi;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItineraryDetailMapper {


  private final PriceOptionMapper priceOptionMapper;
  private final LegRepository legRepository;

  @Autowired
  public ItineraryDetailMapper(
      PriceOptionMapper priceOptionMapper,
      LegRepository legRepository) {
    this.priceOptionMapper = priceOptionMapper;
    this.legRepository = legRepository;
  }

  public ItineraryDetail mapItineraryDetailApiToEntity(ItineraryDetailApi itineraryDetailApi) {

    Optional<ItineraryDetailApi> itineraryDetailApiOptional = Optional.ofNullable(itineraryDetailApi);
    ItineraryDetail itineraryDetail = new ItineraryDetail();

    List<PriceOption> priceOptions = itineraryDetailApiOptional
        .map(ItineraryDetailApi::getPriceOptionApis)
        .orElse(Collections.emptyList())
        .stream()
        .map(priceOptionMapper::mapPriceOptionApiToEntity)
        .collect(Collectors.toList());
    priceOptions.forEach(priceOption -> priceOption.setItineraryDetail(itineraryDetail));

    Leg outboundLeg = itineraryDetailApiOptional
        .map(ItineraryDetailApi::getOutboundLegId)
        .map(legRepository::findByLegId)
        .orElse(null)
        .get(0);
    outboundLeg.getOutboundLegs().add(itineraryDetail);

    if(itineraryDetailApi.getInboundLegId() != null){
      Leg inboundLeg = Objects.requireNonNull(itineraryDetailApiOptional
          .map(ItineraryDetailApi::getInboundLegId)
          .map(legRepository::findByLegId)
          .orElse(null))
          .get(0);
      itineraryDetail.setInboundLeg(inboundLeg);
    }

    itineraryDetail.setOutboundLeg(outboundLeg);
    itineraryDetail.setPriceOptions(priceOptions);

    return itineraryDetail;
  }
}
