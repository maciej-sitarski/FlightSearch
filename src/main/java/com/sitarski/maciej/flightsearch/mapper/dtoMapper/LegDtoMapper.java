package com.sitarski.maciej.flightsearch.mapper.dtoMapper;

import com.sitarski.maciej.flightsearch.dao.ItineraryDetailsRepository;
import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlight;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Carrier;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.PriceOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LegDtoMapper {

  private final ItineraryDetailsRepository itineraryDetailsRepository;

  @Autowired
  public LegDtoMapper(
      ItineraryDetailsRepository itineraryDetailsRepository) {
    this.itineraryDetailsRepository = itineraryDetailsRepository;
  }


  public SingleCardOfFlight mapLegToDto(Leg leg) {

    SingleCardOfFlight singleCardOfFlight = new SingleCardOfFlight();

    Long clientNumber = leg.getItinerary().getClientNumber();
    List<String> carrierImgUrls = leg.getCarriers().stream().map(Carrier::getImageUrl).collect(
        Collectors.toList());
    List<String> carrierNames = leg.getCarriers().stream().map(Carrier::getName).collect(
        Collectors.toList());
    String departureTime = leg.getDeparture();
    String arrivalTime = leg.getArrival();
    String originPlaceCode = leg.getOriginStation().getCode();
    String destinationPlaceCode = leg.getOriginStation().getCode();
    Long duration = leg.getDuration();
    List<Place> stops = leg.getStops();

    List<PriceOption> priceOptions = itineraryDetailsRepository.findByOutboundLegId(leg.getId())
        .get().getPriceOptions();
    Float price = priceFilter(priceOptions);

    singleCardOfFlight.setClientNumber(clientNumber);
    singleCardOfFlight.setCarrierImageUrl(carrierImgUrls);
    singleCardOfFlight.setCarrierName(carrierNames);
    singleCardOfFlight.setDepartureTime(departureTime);
    singleCardOfFlight.setArrivalTime(arrivalTime);
    singleCardOfFlight.setOriginPlaceCode(originPlaceCode);
    singleCardOfFlight.setDestinationPlaceCode(destinationPlaceCode);
    singleCardOfFlight.setDuration(duration);
    singleCardOfFlight.setStops(stops);
    singleCardOfFlight.setPrice(price);

    return singleCardOfFlight;
  }

  private Float priceFilter(List<PriceOption> priceOptions) {
    return priceOptions.stream().sorted(Comparator.comparing(PriceOption::getPrice))
        .collect(Collectors.toList()).get(0).getPrice();
  }

}
