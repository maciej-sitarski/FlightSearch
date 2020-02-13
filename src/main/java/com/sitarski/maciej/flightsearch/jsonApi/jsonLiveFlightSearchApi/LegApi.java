package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties({"SegmentIds","OperatingCarriers"})
public class LegApi {

  @JsonProperty("Id")
  private String legId;

  @JsonProperty("OriginStation")
  private Long originStation;

  @JsonProperty("DestinationStation")
  private Long destinationStation;

  @JsonProperty("Departure")
  private String departure;

  @JsonProperty("Arrival")
  private String arrival;

  @JsonProperty("Duration")
  private Long duration;

  @JsonProperty("JourneyMode")
  private String journeyMode;

  @JsonProperty("Directionality")
  private String directionality;

  @JsonProperty("FlightNumbers")
  private List<FlightNumberApi> flightNumberApis;

  @JsonProperty("Carriers")
  private List<Long> legCarriers;

  @JsonProperty("Stops")
  private List<Long> stops;
}
