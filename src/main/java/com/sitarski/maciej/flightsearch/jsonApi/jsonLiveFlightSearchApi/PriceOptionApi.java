package com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties({"QuoteAgeInMinutes"})
public class PriceOptionApi {

  @JsonProperty("Agents")
  private List<Long> agents;

  @JsonProperty("Price")
  private Float price;

  @JsonProperty("DeeplinkUrl")
  private String linkUrl;
}
