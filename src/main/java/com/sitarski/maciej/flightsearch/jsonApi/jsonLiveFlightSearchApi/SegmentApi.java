package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SegmentApi {

    @JsonProperty("Id")
    private Long id;

    @JsonProperty("DepartureDateTime")
    private String departureDateTime;

    @JsonProperty("ArrivalDateTime")
    private String arrivalDateTime;

    @JsonProperty("Duration")
    private Long duration;
}
