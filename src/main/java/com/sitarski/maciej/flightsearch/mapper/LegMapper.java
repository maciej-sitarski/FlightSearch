package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.dao.CarrierRepository;
import com.sitarski.maciej.flightsearch.dao.PlaceRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Carrier;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.FlightNumber;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.LegApi;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LegMapper {

  @Autowired
  FlightNumberMapper flightNumberMapper;

  @Autowired
  CarrierRepository carrierRepository;

  @Autowired
  PlaceRepository placeRepository;

  public Leg mapLegApiToEntity(LegApi legApi) {

    Optional<LegApi> legApiOptional = Optional.ofNullable(legApi);
    Leg leg = new Leg();

    leg.setArrival(legApiOptional
        .map(LegApi::getArrival)
        .orElse(null));
    leg.setDeparture(legApiOptional
        .map(LegApi::getDeparture)
        .orElse(null));
    leg.setDestinationStation(legApiOptional
        .map(LegApi::getDestinationStation)
        .orElse(null));
    leg.setDirectionality(legApiOptional
        .map(LegApi::getDirectionality)
        .orElse(null));
    leg.setDuration(legApiOptional
        .map(LegApi::getDuration)
        .orElse(null));
    leg.setLegId(legApiOptional
        .map(LegApi::getLegId)
        .orElse(null));
    leg.setJourneyMode(legApiOptional
        .map(LegApi::getJourneyMode)
        .orElse(null));
    leg.setOriginStation(legApiOptional
        .map(LegApi::getOriginStation)
        .orElse(null));

    List<FlightNumber> flightNumbers = legApiOptional
        .map(LegApi::getFlightNumberApis)
        .orElse(Collections.emptyList())
        .stream()
        .map(flightNumberApi -> flightNumberMapper.mapFlightNumberApiToEntity(flightNumberApi))
        .collect(Collectors.toList());
    flightNumbers.forEach(flightNumber -> flightNumber.setLeg(leg));
    leg.setFlightNumbers(flightNumbers);

    List<Carrier> carriers = legApiOptional
        .map(LegApi::getLegCarriers)
        .orElse(Collections.emptyList())
        .stream()
        .map(carrierRepository::findByCarrierId)
        .map(e->e.orElse(null))
        .collect(Collectors.toList());
    carriers.forEach(carrier -> carrier.getLegs().add(leg));
    leg.setLegCarriers(carriers);

    List<Place> places = legApiOptional
        .map(LegApi::getStops)
        .orElse(Collections.emptyList())
        .stream()
        .map(placeRepository::findByPlaceId)
        .map(e->e.orElse(null))
        .collect(Collectors.toList());
    places.forEach(place -> place.getLegs().add(leg));
    leg.setStops(places);

    return leg;
  }

}
