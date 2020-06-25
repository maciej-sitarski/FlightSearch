package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Query;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Segment;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.CarrierApi;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.QueryApi;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.SegmentApi;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class SegmentMapper {

    public Segment mapSegmentApiToEntity(SegmentApi segmentApi) {

        Optional<SegmentApi> segmentApiOptional = Optional.ofNullable(segmentApi);
        Segment segment = new Segment();

        Long segmentId = segmentApiOptional
                .map(SegmentApi::getId)
                .orElse(null);

        String departureDateTime = Objects.requireNonNull(segmentApiOptional
                .map(SegmentApi::getDepartureDateTime)
                .orElse(null))
                .replaceAll("T", " ");

        String arrivalDateTime = segmentApiOptional
                .map(SegmentApi::getArrivalDateTime)
                .orElse(null)
                .replaceAll("T", " ");

        Long duration  = segmentApiOptional
                .map(SegmentApi::getDuration)
                .orElse(null);


        segment.setSegmentId(segmentId);
        segment.setDepartureDateTime(departureDateTime);
        segment.setArrivalDateTime(arrivalDateTime);
        segment.setDuration(duration);

        return segment;
    }
}
