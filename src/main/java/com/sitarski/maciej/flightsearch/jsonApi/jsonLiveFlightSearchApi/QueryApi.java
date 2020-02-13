package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties({"LocationSchema", "GroupPricing"})
public class QueryApi {

  @JsonProperty("Country")
  private String country;

  @JsonProperty("Currency")
  private String currency;

  @JsonProperty("Locale")
  private String locale;

  @JsonProperty("Adults")
  private Long adults;

  @JsonProperty("Children")
  private Long children;

  @JsonProperty("Infants")
  private Long infants;

  @JsonProperty("OriginPlace")
  private String originPlace;

  @JsonProperty("DestinationPlace")
  private String destinationPlace;

  @JsonProperty("OutboundDate")
  private String outboundDate;

  @JsonProperty("InboundDate")
  private String inboundDate;

  @JsonProperty("CabinClass")
  private String cabinClass;
}
