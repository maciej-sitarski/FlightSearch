package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Segment;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.SegmentApi;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class SegmentMapper {

  public Segment mapSegmentApiToEntity(SegmentApi segmentApi) {

    Optional<SegmentApi> segmentApiOptional = Optional.ofNullable(segmentApi);
    Segment segment = new Segment();

    segment.setSegmentId(segmentApiOptional
        .map(SegmentApi::getId)
        .orElse(null));
    segment.setArrivalDateTime(segmentApiOptional
        .map(SegmentApi::getArrivalDateTime)
        .orElse(null));
    segment.setCarrierId(segmentApiOptional
        .map(SegmentApi::getCarrierId)
        .orElse(null));
    segment.setDepartureDateTime(segmentApiOptional
        .map(SegmentApi::getDepartureDateTime)
        .orElse(null));
    segment.setDestinationStation(segmentApiOptional
        .map(SegmentApi::getDestinationStation)
        .orElse(null));
    segment.setDirectionality(segmentApiOptional
        .map(SegmentApi::getDirectionality)
        .orElse(null));
    segment.setDuration(segmentApiOptional
        .map(SegmentApi::getDuration)
        .orElse(null));
    segment.setFlightNumber(segmentApiOptional
        .map(SegmentApi::getFlightNumber)
        .orElse(null));
    segment.setOperatingCarrierId(segmentApiOptional
        .map(SegmentApi::getOperatingCarrierId)
        .orElse(null));
    segment.setOriginStation(segmentApiOptional
        .map(SegmentApi::getOriginStation)
        .orElse(null));

    return segment;
  }
}
