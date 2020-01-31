package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties({"BookingDetailsLink"})
public class ItineraryDetail {

  @JsonProperty("OutboundLegId")
  private String outboundLegId;

  @JsonProperty("InboundLegId")
  private String inboundLegId;

  @JsonProperty("PricingOptions")
  private List<PriceOption> priceOptions;

  public ItineraryDetail() {
  }

  public ItineraryDetail(String outboundLegId, String inboundLegId, List<PriceOption> priceOptions) {
    this.outboundLegId = outboundLegId;
    this.inboundLegId = inboundLegId;
    this.priceOptions = priceOptions;
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

  public List<PriceOption> getPriceOptions() {
    return priceOptions;
  }

  public void setPriceOptions(
      List<PriceOption> priceOptions) {
    this.priceOptions = priceOptions;
  }
}
