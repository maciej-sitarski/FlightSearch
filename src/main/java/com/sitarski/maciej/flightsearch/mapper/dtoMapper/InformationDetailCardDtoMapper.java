package com.sitarski.maciej.flightsearch.mapper.dtoMapper;

import com.sitarski.maciej.flightsearch.dto.InformationDetailCardDto;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Carrier;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Segment;
import org.springframework.stereotype.Component;

@Component
public class InformationDetailCardDtoMapper {


  public InformationDetailCardDto getInformationDetailCardDto(Leg leg){

    InformationDetailCardDto informationDetailCardDto = new InformationDetailCardDto();

    String clientNumber = leg.getClientNumber();
    List<String> carrierImgUrls = leg.getCarriers().stream().map(Carrier::getImageUrl).collect(
        Collectors.toList());
    List<String> carrierNames = leg.getCarriers().stream().map(Carrier::getName).collect(
        Collectors.toList());
    LocalDateTime departureTime = leg.getDeparture();
    LocalDateTime arrivalTime = leg.getArrival();
    String originPlace = leg.getOriginStation().getName();
    String destinationPlace = leg.getDestinationStation().getName();
    String originPlaceCode = leg.getOriginStation().getCode();
    String destinationPlaceCode = leg.getDestinationStation().getCode();
    Long duration = leg.getDuration();
    List<Place> stops = leg.getStops();
    String directionality =  leg.getDirectionality();
    List<Long> durations = leg.getSegments().stream().map(Segment::getDuration).collect(Collectors.toList());
    List<String> departureDateTime = leg.getSegments().stream().map(Segment::getDepartureDateTime).collect(Collectors.toList());
    List<String> arrivalDateTime = leg.getSegments().stream().map(Segment::getArrivalDateTime).collect(Collectors.toList());


    informationDetailCardDto.setClientNumber(clientNumber);
    informationDetailCardDto.setCarrierImageUrl(carrierImgUrls);
    informationDetailCardDto.setCarrierName(carrierNames);
    informationDetailCardDto.setDepartureTime(departureTime);
    informationDetailCardDto.setArrivalTime(arrivalTime);
    informationDetailCardDto.setOriginPlace(originPlace);
    informationDetailCardDto.setDestinationPlace(destinationPlace);
    informationDetailCardDto.setOriginPlaceCode(originPlaceCode);
    informationDetailCardDto.setDestinationPlaceCode(destinationPlaceCode);
    informationDetailCardDto.setDuration(duration);
    informationDetailCardDto.setStops(stops);
    informationDetailCardDto.setDirectionality(directionality);
    informationDetailCardDto.setDurations(durations);
    informationDetailCardDto.setDepartureDateTime(departureDateTime);
    informationDetailCardDto.setArrivalDateTime(arrivalDateTime);

    return informationDetailCardDto;
  }

}
