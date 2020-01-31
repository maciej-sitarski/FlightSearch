package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.PlaceApi;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class PlaceMapper {

  public Place mapPlaceApiToEntity(PlaceApi placeApi) {

    Optional<PlaceApi> placeApiOptional = Optional.ofNullable(placeApi);
    Place place = new Place();

    place.setCode(placeApiOptional
        .map(PlaceApi::getCode)
        .orElse(null));
    place.setPlaceId(placeApiOptional
        .map(PlaceApi::getId)
        .orElse(null));
    place.setParentId(placeApiOptional
        .map(PlaceApi::getParentId)
        .orElse(null));
    place.setName(placeApiOptional
        .map(PlaceApi::getName)
        .orElse(null));
    place.setType(placeApiOptional
        .map(PlaceApi::getType)
        .orElse(null));

    return place;
  }
}
