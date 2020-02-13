package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.dao.AgentRepository;
import com.sitarski.maciej.flightsearch.dao.CarrierRepository;
import com.sitarski.maciej.flightsearch.dao.ItineraryDetailsRepository;
import com.sitarski.maciej.flightsearch.dao.LegRepository;
import com.sitarski.maciej.flightsearch.dao.PlaceRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Agent;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Carrier;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Currency;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.ItineraryDetail;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Query;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.ItineraryApi;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItineraryMapper {

  private final QueryMapper queryMapper;
  private final ItineraryDetailMapper itineraryDetailMapper;
  private final AgentMapper agentMapper;
  private final CarrierMapper carrierMapper;
  private final CurrencyMapper currencyMapper;
  private final LegMapper legMapper;
  private final PlaceMapper placeMapper;
  private final AgentRepository agentRepository;
  private final CarrierRepository carrierRepository;
  private final PlaceRepository placeRepository;
  private final ItineraryDetailsRepository itineraryDetailsRepository;
  private final LegRepository legRepository;

  @Autowired
  public ItineraryMapper(QueryMapper queryMapper,
      ItineraryDetailMapper itineraryDetailMapper,
      AgentMapper agentMapper, CarrierMapper carrierMapper,
      CurrencyMapper currencyMapper, LegMapper legMapper,
      PlaceMapper placeMapper,
      AgentRepository agentRepository,
      CarrierRepository carrierRepository,
      PlaceRepository placeRepository,
      ItineraryDetailsRepository itineraryDetailsRepository,
      LegRepository legRepository) {
    this.queryMapper = queryMapper;
    this.itineraryDetailMapper = itineraryDetailMapper;
    this.agentMapper = agentMapper;
    this.carrierMapper = carrierMapper;
    this.currencyMapper = currencyMapper;
    this.legMapper = legMapper;
    this.placeMapper = placeMapper;
    this.agentRepository = agentRepository;
    this.carrierRepository = carrierRepository;
    this.placeRepository = placeRepository;
    this.itineraryDetailsRepository = itineraryDetailsRepository;
    this.legRepository = legRepository;
  }

  public Itinerary mapItineraryApiToEntity(ItineraryApi itineraryApi, String clientNumber) {

    Optional<ItineraryApi> itineraryApiOptional = Optional.ofNullable(itineraryApi);
    Itinerary itinerary = new Itinerary();

    String sessionKey = itineraryApiOptional
        .map(ItineraryApi::getSessionKey)
        .orElse(null);

    String status = itineraryApiOptional
        .map(ItineraryApi::getStatus)
        .orElse(null);

    Query query = queryMapper.mapQueryApiToEntity(itineraryApiOptional
        .map(ItineraryApi::getQueryApi)
        .orElse(null));

    List<Leg> legs = legRepository.findAllByClientNumber(clientNumber);
    legs.forEach(leg -> leg.setItinerary(itinerary));

    List<ItineraryDetail> itineraryDetails = itineraryDetailsRepository.findAllByClientNumber(clientNumber);
    itineraryDetails.forEach(itineraryDetail -> itineraryDetail.setItinerary(itinerary));

    List<Currency> currencies = itineraryApiOptional
        .map(ItineraryApi::getCurrencyApi)
        .orElse(Collections.emptyList())
        .stream()
        .map(currencyMapper::mapCurrencyApiToEntity)
        .collect(Collectors.toList());
    currencies.forEach(currency -> currency.setItinerary(itinerary));

    itinerary.setSessionKey(sessionKey);
    itinerary.setStatus(status);
    itinerary.setQuery(query);
    itinerary.setItineraryDetail(itineraryDetails);
    itinerary.setCurrency(currencies);
    itinerary.setLeg(legs);

    return itinerary;
  }
}
