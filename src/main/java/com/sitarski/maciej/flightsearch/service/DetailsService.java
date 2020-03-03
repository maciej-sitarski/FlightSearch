package com.sitarski.maciej.flightsearch.service;

import com.sitarski.maciej.flightsearch.dao.ItineraryDetailsRepository;
import com.sitarski.maciej.flightsearch.dao.LegRepository;
import com.sitarski.maciej.flightsearch.dto.DetailCardDto;
import com.sitarski.maciej.flightsearch.dto.InformationDetailCardDto;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.ItineraryDetail;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import com.sitarski.maciej.flightsearch.mapper.dtoMapper.DetailCardDtoMapper;
import com.sitarski.maciej.flightsearch.mapper.dtoMapper.InformationDetailCardDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsService {

  private final ItineraryDetailsRepository itineraryDetailsRepository;
  private final LegRepository legRepository;
  private final DetailCardDtoMapper detailCardDtoMapper;
  private final InformationDetailCardDtoMapper informationDetailCardDtoMapper;


  @Autowired
  public DetailsService(
      ItineraryDetailsRepository itineraryDetailsRepository,
      LegRepository legRepository,
      DetailCardDtoMapper detailCardDtoMapper,
      InformationDetailCardDtoMapper informationDetailCardDtoMapper) {
    this.itineraryDetailsRepository = itineraryDetailsRepository;
    this.legRepository = legRepository;
    this.detailCardDtoMapper = detailCardDtoMapper;
    this.informationDetailCardDtoMapper = informationDetailCardDtoMapper;
  }

  public List<DetailCardDto> getListOfDetailCardDto(Long legId){
    ItineraryDetail itineraryDetail = itineraryDetailsRepository.findByOutboundLegId(legId).orElse(null);
    return itineraryDetail.getPriceOptions().stream().map(
        detailCardDtoMapper::mapPricingOptionToDto).collect(
        Collectors.toList());
  }

  public InformationDetailCardDto getInformationDetailCardDto(Long legId){
    Leg leg = legRepository.findById(legId).orElse(null);
    return informationDetailCardDtoMapper.getInformationDetailCardDto(leg);
  }
}
