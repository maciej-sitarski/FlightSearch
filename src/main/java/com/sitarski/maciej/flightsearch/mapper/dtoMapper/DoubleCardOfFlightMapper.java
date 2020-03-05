package com.sitarski.maciej.flightsearch.mapper.dtoMapper;

import com.sitarski.maciej.flightsearch.dto.DoubleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.ItineraryDetail;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.PriceOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoubleCardOfFlightMapper {

  private final SingleCardOfFlightMapper singleCardOfFlightMapper;

  @Autowired
  public DoubleCardOfFlightMapper(
      SingleCardOfFlightMapper singleCardOfFlightMapper) {
    this.singleCardOfFlightMapper = singleCardOfFlightMapper;
  }

  public DoubleCardOfFlightDto mapItineraryDetailToDto(ItineraryDetail itineraryDetail){

    DoubleCardOfFlightDto doubleCardOfFlightDto = new DoubleCardOfFlightDto();

    SingleCardOfFlightDto outboundLeg = singleCardOfFlightMapper.mapLegToDto(itineraryDetail.getOutboundLeg());
    SingleCardOfFlightDto inboundLeg = singleCardOfFlightMapper.mapLegToDto(itineraryDetail.getInboundLeg());
    Long outboundLegId = itineraryDetail.getOutboundLeg().getId();
    Long inboundLegId = itineraryDetail.getInboundLeg().getId();
    String clientNumber = itineraryDetail.getClientNumber();
    List<PriceOption> priceOptions = itineraryDetail.getPriceOptions();
    Float price = priceFilter(priceOptions);

    doubleCardOfFlightDto.setOutboundLeg(outboundLeg);
    doubleCardOfFlightDto.setInboundLeg(inboundLeg);
    doubleCardOfFlightDto.setOutboundLegId(outboundLegId);
    doubleCardOfFlightDto.setInboundLegId(inboundLegId);
    doubleCardOfFlightDto.setPriceOptions(priceOptions);
    doubleCardOfFlightDto.setClientNumber(clientNumber);
    doubleCardOfFlightDto.setPrice(price);

    return doubleCardOfFlightDto;
  }

  private Float priceFilter(List<PriceOption> priceOptions) {
    return priceOptions.stream().sorted(Comparator.comparing(PriceOption::getPrice))
        .collect(Collectors.toList()).get(0).getPrice();
  }
}
