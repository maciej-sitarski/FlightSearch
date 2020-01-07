package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"PricingOptions", "BookingDetailsLink"})
public class ItineraryDetail {

  @JsonProperty("OutboundLegId")
  private String outboundLegId;

  @JsonProperty("InboundLegId")
  private String inboundLegId;

  public ItineraryDetail() {
  }

  public ItineraryDetail(String outboundLegId, String inboundLegId) {
    this.outboundLegId = outboundLegId;
    this.inboundLegId = inboundLegId;
  }

  public String getOutboundLegId() {
    return outboundLegId;
  }

  public void setOutboundLegId(String outboundLegId) {
    this.outboundLegId = outboundLegId;
  }

  public String getInboundLegId() {
    return inboundLegId;
  }

  public void setInboundLegId(String inboundLegId) {
    this.inboundLegId = inboundLegId;
  }
}
