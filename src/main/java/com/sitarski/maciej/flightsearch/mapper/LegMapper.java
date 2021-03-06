package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.dao.CarrierRepository;
import com.sitarski.maciej.flightsearch.dao.PlaceRepository;
import com.sitarski.maciej.flightsearch.dao.SegmentRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.*;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.LegApi;
import com.sitarski.maciej.flightsearch.service.StringFormatService;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LegMapper {

  private final FlightNumberMapper flightNumberMapper;
  private final CarrierRepository carrierRepository;
  private final SegmentRepository segmentRepository;
  private final PlaceRepository placeRepository;
  private final StringFormatService stringFormatService;

  @Autowired
  public LegMapper(
          FlightNumberMapper flightNumberMapper,
          CarrierRepository carrierRepository,
          SegmentRepository segmentRepository, PlaceRepository placeRepository,
          StringFormatService stringFormatService){
    this.flightNumberMapper = flightNumberMapper;
    this.carrierRepository = carrierRepository;
    this.segmentRepository = segmentRepository;
    this.placeRepository = placeRepository;
    this.stringFormatService = stringFormatService;
  }

  public Leg mapLegApiToEntity(LegApi legApi) {

    Optional<LegApi> legApiOptional = Optional.ofNullable(legApi);
    Leg leg = new Leg();

    LocalDateTime arrival = stringFormatService.formatStringDateToDate(
        Objects.requireNonNull(legApiOptional
            .map(LegApi::getArrival)
            .orElse(null)));

    LocalDateTime departure = stringFormatService.formatStringDateToDate(legApiOptional
        .map(LegApi::getDeparture)
        .orElse(null));

    String directionality = legApiOptional
        .map(LegApi::getDirectionality)
        .orElse(null);

    Long duration = legApiOptional
        .map(LegApi::getDuration)
        .orElse(null);

    String legId = legApiOptional
        .map(LegApi::getLegId)
        .orElse(null);

    String journeyMode = legApiOptional
        .map(LegApi::getJourneyMode)
        .orElse(null);

    Place destinationStation = Objects.requireNonNull(legApiOptional
        .map(LegApi::getDestinationStation)
        .map(placeRepository::findAllByPlaceId)
        .orElse(null))
        .get(0);

    Place originStation = Objects.requireNonNull(legApiOptional
        .map(LegApi::getOriginStation)
        .map(placeRepository::findAllByPlaceId)
        .orElse(null))
        .get(0);

    List<FlightNumber> flightNumbers = legApiOptional
        .map(LegApi::getFlightNumberApis)
        .orElse(Collections.emptyList())
        .stream()
        .map(flightNumberMapper::mapFlightNumberApiToEntity)
        .collect(Collectors.toList());
    flightNumbers.forEach(flightNumber -> flightNumber.setLeg(leg));

    List<Carrier> carriers = legApiOptional
        .map(LegApi::getLegCarriers)
        .orElse(Collections.emptyList())
        .stream()
        .map(carrierRepository::findAllByCarrierId)
        .map(carriers1 -> carriers1.get(0))
        .collect(Collectors.toList());
    carriers.forEach(carrier -> carrier.getLegs().add(leg));

    List<Segment> segments = legApiOptional
            .map(LegApi::getSegmentApis)
            .orElse(Collections.emptyList())
            .stream()
            .map(segmentRepository::findAllBySegmentId)
            .map(segments1 -> segments1.get(0))
            .collect(Collectors.toList());
    segments.forEach(segment -> segment.getLegs().add(leg));

    List<Place> places = legApiOptional
        .map(LegApi::getStops)
        .orElse(Collections.emptyList())
        .stream()
        .map(placeRepository::findAllByPlaceId)
        .map(places1 -> places1.get(0))
        .collect(Collectors.toList());
    places.forEach(place -> place.getLegs().add(leg));

    leg.setArrival(arrival);
    leg.setDeparture(departure);
    leg.setDirectionality(directionality);
    leg.setDuration(duration);
    leg.setLegId(legId);
    leg.setJourneyMode(journeyMode);
    leg.setDestinationStation(destinationStation);
    leg.setOriginStation(originStation);
    leg.setFlightNumbers(flightNumbers);
    leg.setStops(places);
    leg.setCarriers(carriers);

    return leg;
  }

}
