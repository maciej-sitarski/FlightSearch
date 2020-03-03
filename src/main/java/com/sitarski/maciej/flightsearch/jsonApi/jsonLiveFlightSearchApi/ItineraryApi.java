package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties({"ValidationErrors", "Segments", "message"})
public class ItineraryApi {

  @JsonProperty("SessionKey")
  private String sessionKey;

  @JsonProperty("Status")
  private String status;

  @JsonProperty("Query")
  private QueryApi queryApi;

  @JsonProperty("Itineraries")
  private List<ItineraryDetailApi> itineraryDetailApi;

  @JsonProperty("Legs")
  private List<LegApi> legApi;

  @JsonProperty("Carriers")
  private List<CarrierApi> carrierApi;

  @JsonProperty("Agents")
  private List<AgentApi> agentApi;

  @JsonProperty("Places")
  private List<PlaceApi> placeApi;

  @JsonProperty("Currencies")
  private List<CurrencyApi> currencyApi;
}
