package com.sitarski.maciej.flightsearch.mapper.dtoMapper;

import com.sitarski.maciej.flightsearch.dao.ItineraryDetailsRepository;
import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Carrier;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.PriceOption;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingleCardOfFlightMapper {

  private final ItineraryDetailsRepository itineraryDetailsRepository;

  @Autowired
  public SingleCardOfFlightMapper(
      ItineraryDetailsRepository itineraryDetailsRepository) {
    this.itineraryDetailsRepository = itineraryDetailsRepository;
  }


  public SingleCardOfFlightDto mapLegToDto(Leg leg){

    SingleCardOfFlightDto singleCardOfFlightDto = new SingleCardOfFlightDto();

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

    if(itineraryDetailsRepository.findAllByClientNumber(clientNumber).get(0).getInboundLeg() == null){
      List<PriceOption> priceOptions = itineraryDetailsRepository.findByOutboundLegId(leg.getId())
          .get().getPriceOptions();
      Float price = priceFilter(priceOptions);
      singleCardOfFlightDto.setPrice(price);
    }

    singleCardOfFlightDto.setClientNumber(clientNumber);
    singleCardOfFlightDto.setCarrierImageUrl(carrierImgUrls);
    singleCardOfFlightDto.setCarrierName(carrierNames);
    singleCardOfFlightDto.setDepartureTime(departureTime);
    singleCardOfFlightDto.setArrivalTime(arrivalTime);
    singleCardOfFlightDto.setOriginPlace(originPlace);
    singleCardOfFlightDto.setDestinationPlace(destinationPlace);
    singleCardOfFlightDto.setOriginPlaceCode(originPlaceCode);
    singleCardOfFlightDto.setDestinationPlaceCode(destinationPlaceCode);
    singleCardOfFlightDto.setDuration(duration);
    singleCardOfFlightDto.setStops(stops);

    return singleCardOfFlightDto;
  }

  private Float priceFilter(List<PriceOption> priceOptions) {
    return priceOptions.stream().sorted(Comparator.comparing(PriceOption::getPrice))
        .collect(Collectors.toList()).get(0).getPrice();
  }

}
