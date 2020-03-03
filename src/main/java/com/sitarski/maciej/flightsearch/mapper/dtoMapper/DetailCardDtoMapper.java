package com.sitarski.maciej.flightsearch.mapper.dtoMapper;

import com.sitarski.maciej.flightsearch.dto.DetailCardDto;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.PriceOption;
import org.springframework.stereotype.Component;

@Component
public class DetailCardDtoMapper {

  public DetailCardDto mapPricingOptionToDto(PriceOption priceOption){

    DetailCardDto detailCardDto = new DetailCardDto();

    String agentsName = priceOption.getAgents().get(0).getName();
    Float price = priceOption.getPrice();
    String uri = priceOption.getLinkUrl();


    detailCardDto.setAgentsName(agentsName);
    detailCardDto.setPrice(price);
    detailCardDto.setUri(uri);

    return detailCardDto;
  }
}
