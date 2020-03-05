package com.sitarski.maciej.flightsearch.dto;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.PriceOption;
import java.util.List;
import lombok.Data;

@Data
public class DoubleCardOfFlightDto {

  private String clientNumber;
  private SingleCardOfFlightDto outboundLeg;
  private SingleCardOfFlightDto inboundLeg;
  private Long outboundLegId;
  private Long inboundLegId;
  private List<PriceOption> priceOptions;
  private Float price;

}
