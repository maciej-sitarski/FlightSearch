package com.sitarski.maciej.flightsearch.mapper.dtoMapper;

import com.sitarski.maciej.flightsearch.dto.InformationCardDto;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Query;
import org.springframework.stereotype.Component;

@Component
public class InformationCardMapper {

  public InformationCardDto mapQueryToDto(Query query) {

    InformationCardDto informationCardDto = new InformationCardDto();

    String outboundDate = query.getOutboundDate();
    String cabinClass = query.getCabinClass();
    Long adults = query.getAdults();
    Long children = query.getChildren();
    Long infants = query.getInfants();

    if (query.getInboundDate() != null) {
      String inboundDate = query.getInboundDate();
      informationCardDto.setInboundDate(inboundDate);
    } else {
      informationCardDto.setInboundDate(null);
    }

    informationCardDto.setOutboundDate(outboundDate);
    informationCardDto.setCabinClass(cabinClass);
    informationCardDto.setAdults(adults);
    informationCardDto.setChildren(children);
    informationCardDto.setInfants(infants);

    return informationCardDto;
  }
}
