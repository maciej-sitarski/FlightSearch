package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Agent;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Carrier;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Currency;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.ItineraryDetail;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Query;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Segment;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.ItineraryApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItineraryMapper {

  @Autowired
  QueryMapper queryMapper;

  @Autowired
  ItineraryDetailMapper itineraryDetailMapper;

  @Autowired
  AgentMapper agentMapper;

  @Autowired
  CarrierMapper carrierMapper;

  @Autowired
  CurrencyMapper currencyMapper;

  @Autowired
  LegMapper legMapper;

  @Autowired
  PlaceMapper placeMapper;

  @Autowired
  SegmentMapper segmentMapper;

  public Itinerary mapItineraryApiToEntity(ItineraryApi itineraryApi) {

    Optional<ItineraryApi> itineraryApiOptional = Optional.ofNullable(itineraryApi);
    Itinerary itinerary = new Itinerary();

    itinerary.setSessionKey(itineraryApiOptional
        .map(ItineraryApi::getSessionKey)
        .orElse(null));

    itinerary.setStatus(itineraryApiOptional
        .map(ItineraryApi::getStatus)
        .orElse(null));

    Query query = queryMapper.mapQueryApiToEntity(itineraryApiOptional
        .map(ItineraryApi::getQueryApi)
        .orElse(null));
    itinerary.setQuery(query);

    List<ItineraryDetail> itineraryDetails = itineraryApiOptional
        .map(ItineraryApi::getItineraryDetailApi)
        .orElse(Collections.emptyList())
        .stream()
        .map(itineraryDetailMapper::mapItineraryDetailApiToEntity)
        .collect(Collectors.toList());
    itinerary.setItineraryDetail(itineraryDetails);

    List<Agent> agents = itineraryApiOptional
        .map(ItineraryApi::getAgentApi)
        .orElse(Collections.emptyList())
        .stream()
        .map(agentMapper::mapAgentApiToEntity)
        .collect(Collectors.toList());
    itinerary.setAgent(agents);

    List<Carrier> carriers = itineraryApiOptional
        .map(ItineraryApi::getCarrierApi)
        .orElse(Collections.emptyList())
        .stream()
        .map(carrierMapper::mapCarrierApiToEntity)
        .collect(Collectors.toList());
    itinerary.setCarrier(carriers);

    List<Currency> currencies = itineraryApiOptional
        .map(ItineraryApi::getCurrencyApi)
        .orElse(Collections.emptyList())
        .stream()
        .map(currencyMapper::mapCurrencyApiToEntity)
        .collect(Collectors.toList());
    itinerary.setCurrency(currencies);

    List<Leg> legs = itineraryApiOptional
        .map(ItineraryApi::getLegApi)
        .orElse(Collections.emptyList())
        .stream()
        .map(legMapper::mapLegApiToEntity)
        .collect(Collectors.toList());
    itinerary.setLeg(legs);

    List<Place> places = itineraryApiOptional
        .map(ItineraryApi::getPlaceApi)
        .orElse(Collections.emptyList())
        .stream()
        .map(placeMapper::mapPlaceApiToEntity)
        .collect(Collectors.toList());
    itinerary.setPlace(places);

    List<Segment> segments = itineraryApiOptional
        .map(ItineraryApi::getSegmentApi)
        .orElse(Collections.emptyList())
        .stream()
        .map(segmentMapper::mapSegmentApiToEntity)
        .collect(Collectors.toList());
    itinerary.setSegment(segments);

    return itinerary;
  }
}
