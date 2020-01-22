package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties({"ValidationErrors"})
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

  @JsonProperty("Segments")
  private List<SegmentApi> segmentApi;

  @JsonProperty("Carriers")
  private List<CarrierApi> carrierApi;

  @JsonProperty("Agents")
  private List<AgentApi> agentApi;

  @JsonProperty("Places")
  private List<PlaceApi> placeApi;

  @JsonProperty("Currencies")
  private List<CurrencyApi> currencyApi;

  public ItineraryApi() {
  }

  public ItineraryApi(String sessionKey, String status, QueryApi queryApi,
      List<ItineraryDetailApi> itineraryDetailApi, List<LegApi> legApi, List<SegmentApi> segmentApi,
      List<CarrierApi> carrierApi, List<AgentApi> agentApi, List<PlaceApi> placeApi,
      List<CurrencyApi> currencyApi) {
    this.sessionKey = sessionKey;
    this.status = status;
    this.queryApi = queryApi;
    this.itineraryDetailApi = itineraryDetailApi;
    this.legApi = legApi;
    this.segmentApi = segmentApi;
    this.carrierApi = carrierApi;
    this.agentApi = agentApi;
    this.placeApi = placeApi;
    this.currencyApi = currencyApi;
  }

  public String getSessionKey() {
    return sessionKey;
  }

  public void setSessionKey(String sessionKey) {
    this.sessionKey = sessionKey;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public QueryApi getQueryApi() {
    return queryApi;
  }

  public void setQueryApi(QueryApi queryApi) {
    this.queryApi = queryApi;
  }

  public List<ItineraryDetailApi> getItineraryDetailApi() {
    return itineraryDetailApi;
  }

  public void setItineraryDetailApi(List<ItineraryDetailApi> itineraryDetailApi) {
    this.itineraryDetailApi = itineraryDetailApi;
  }

  public List<LegApi> getLegApi() {
    return legApi;
  }

  public void setLegApi(List<LegApi> legApi) {
    this.legApi = legApi;
  }

  public List<SegmentApi> getSegmentApi() {
    return segmentApi;
  }

  public void setSegmentApi(List<SegmentApi> segmentApi) {
    this.segmentApi = segmentApi;
  }

  public List<CarrierApi> getCarrierApi() {
    return carrierApi;
  }

  public void setCarrierApi(List<CarrierApi> carrierApi) {
    this.carrierApi = carrierApi;
  }

  public List<AgentApi> getAgentApi() {
    return agentApi;
  }

  public void setAgentApi(List<AgentApi> agentApi) {
    this.agentApi = agentApi;
  }

  public List<PlaceApi> getPlaceApi() {
    return placeApi;
  }

  public void setPlaceApi(List<PlaceApi> placeApi) {
    this.placeApi = placeApi;
  }

  public List<CurrencyApi> getCurrencyApi() {
    return currencyApi;
  }

  public void setCurrencyApi(List<CurrencyApi> currencyApi) {
    this.currencyApi = currencyApi;
  }
}
