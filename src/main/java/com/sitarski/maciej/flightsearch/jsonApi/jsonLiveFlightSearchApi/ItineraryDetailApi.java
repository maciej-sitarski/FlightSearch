package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties({"BookingDetailsLink"})
public class ItineraryDetailApi {

  @JsonProperty("OutboundLegId")
  private String outboundLegId;

  @JsonProperty("InboundLegId")
  private String inboundLegId;

  @JsonProperty("PricingOptions")
  private List<PriceOptionApi> priceOptionApis;
}
