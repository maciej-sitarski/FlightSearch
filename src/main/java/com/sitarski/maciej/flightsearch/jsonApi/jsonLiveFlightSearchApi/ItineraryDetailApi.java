package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties({"BookingDetailsLink"})
public class ItineraryDetailApi {

  @JsonProperty("OutboundLegId")
  private String outboundLegId;

  @JsonProperty("InboundLegId")
  private String inboundLegId;

  @JsonProperty("PricingOptions")
  private List<PriceOptionApi> priceOptionApis;

  public ItineraryDetailApi() {
  }

  public ItineraryDetailApi(String outboundLegId, String inboundLegId, List<PriceOptionApi> priceOptionApis) {
    this.outboundLegId = outboundLegId;
    this.inboundLegId = inboundLegId;
    this.priceOptionApis = priceOptionApis;
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

  public List<PriceOptionApi> getPriceOptionApis() {
    return priceOptionApis;
  }

  public void setPriceOptionApis(
      List<PriceOptionApi> priceOptionApis) {
    this.priceOptionApis = priceOptionApis;
  }
}
