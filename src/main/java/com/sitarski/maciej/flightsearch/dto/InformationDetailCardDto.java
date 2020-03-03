package com.sitarski.maciej.flightsearch.dto;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class InformationDetailCardDto {

  private String clientNumber;
  private List<String> carrierImageUrl;
  private List<String> carrierName;
  private LocalDateTime departureTime;
  private LocalDateTime arrivalTime;
  private String originPlaceCode;
  private String destinationPlaceCode;
  private String originPlace;
  private String destinationPlace;
  private Long duration;
  private List<Place> stops;
  private String directionality;

}
