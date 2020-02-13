package com.sitarski.maciej.flightsearch.mapper.dtoMapper;

import com.sitarski.maciej.flightsearch.dto.QueryDto;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Query;
import org.springframework.stereotype.Component;

@Component
public class QueryDtoMapper {

  public QueryDto mapQueryToDto(Query query) {

    QueryDto queryDto = new QueryDto();

    String originPlace = query.getOriginPlace();
    String destinationPlace = query.getDestinationPlace();
    String outboundDate = query.getOutboundDate();
    String cabinClass = query.getCabinClass();
    Long adults = query.getAdults();
    Long children = query.getChildren();
    Long infants = query.getInfants();

    if (query.getInboundDate() != null) {
      String inboundDate = query.getInboundDate();
      queryDto.setInboundDate(inboundDate);
    } else {
      queryDto.setInboundDate(null);
    }

    queryDto.setOriginPlace(originPlace);
    queryDto.setDestinationPlace(destinationPlace);
    queryDto.setOutboundDate(outboundDate);
    queryDto.setCabinClass(cabinClass);
    queryDto.setAdults(adults);
    queryDto.setChildren(children);
    queryDto.setInfants(infants);

    return queryDto;
  }
}
