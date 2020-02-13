package com.sitarski.maciej.flightsearch.dto;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import java.util.List;
import lombok.Data;

@Data
public class SingleCardOfFlight {

  private Long clientNumber;
  private List<String> carrierImageUrl;
  private List<String> carrierName;
  private String departureTime;
  private String arrivalTime;
  private String originPlaceCode;
  private String destinationPlaceCode;
  private Long duration;
  private List<Place> stops;
  private Float price;
}
