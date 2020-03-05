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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsService {

  private final ItineraryDetailsRepository itineraryDetailsRepository;
  private final LegRepository legRepository;
  private final DetailCardDtoMapper detailCardDtoMapper;
  private final InformationDetailCardDtoMapper informationDetailCardDtoMapper;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());


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
    logger.info("Get list of detail card dto");
    ItineraryDetail itineraryDetail = itineraryDetailsRepository.findAllByOutboundLegId(legId).get(0);
    return itineraryDetail.getPriceOptions().stream().map(
        detailCardDtoMapper::mapPricingOptionToDto).collect(
        Collectors.toList());
  }

  public List<DetailCardDto> getListOfReturnFlightDetailCardDto(Long outboundlegId, Long inboundLegId){
    logger.info("Get list of return flight detail card dto");
    ItineraryDetail itineraryDetail = itineraryDetailsRepository.findAllByOutboundLegIdAndInboundLegId(outboundlegId, inboundLegId).get(0);
    return itineraryDetail.getPriceOptions().stream().map(
        detailCardDtoMapper::mapPricingOptionToDto).collect(
        Collectors.toList());
  }

  public InformationDetailCardDto getInformationDetailCardDto(Long legId){
    logger.info("Get information detail card dto");
    Leg leg = legRepository.findAllById(legId).get(0);
    return informationDetailCardDtoMapper.getInformationDetailCardDto(leg);
  }
}
