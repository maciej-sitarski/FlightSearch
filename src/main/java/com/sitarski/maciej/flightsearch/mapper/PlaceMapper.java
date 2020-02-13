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

    String code = placeApiOptional
        .map(PlaceApi::getCode)
        .orElse(null);

    Long placeId = placeApiOptional
        .map(PlaceApi::getId)
        .orElse(null);

    Long parentId = placeApiOptional
        .map(PlaceApi::getParentId)
        .orElse(null);

    String name = placeApiOptional
        .map(PlaceApi::getName)
        .orElse(null);

    String type = placeApiOptional
        .map(PlaceApi::getType)
        .orElse(null);

    place.setCode(code);
    place.setPlaceId(placeId);
    place.setParentId(parentId);
    place.setName(name);
    place.setType(type);

    return place;
  }
}
