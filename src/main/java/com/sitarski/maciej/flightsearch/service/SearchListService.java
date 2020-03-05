package com.sitarski.maciej.flightsearch.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dao.LegRepository;
import com.sitarski.maciej.flightsearch.dto.DoubleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.dto.InformationCardDto;
import com.sitarski.maciej.flightsearch.entity.FilterForm;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import com.sitarski.maciej.flightsearch.entity.SearchForm;
import com.sitarski.maciej.flightsearch.mapper.dtoMapper.DoubleCardOfFlightMapper;
import com.sitarski.maciej.flightsearch.mapper.dtoMapper.InformationCardMapper;
import com.sitarski.maciej.flightsearch.mapper.dtoMapper.SingleCardOfFlightMapper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchListService {

  private final SingleCardOfFlightMapper singleCardOfFlightMapper;
  private final DoubleCardOfFlightMapper doubleCardOfFlightMapper;
  private final InformationCardMapper informationCardMapper;
  private final ItineraryService itineraryService;
  private final DataService dataService;
  private final FilterOneWayService filterOneWayService;
  private final FilterMultipleService filterMultipleService;
  private final UserService userService;
  private final LegRepository legRepository;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  public SearchListService(
      SingleCardOfFlightMapper singleCardOfFlightMapper,
      DoubleCardOfFlightMapper doubleCardOfFlightMapper,
      InformationCardMapper informationCardMapper,
      ItineraryService itineraryService,
      DataService dataService, FilterOneWayService filterOneWayService,
      FilterMultipleService filterMultipleService,
      UserService userService, LegRepository legRepository) {
    this.singleCardOfFlightMapper = singleCardOfFlightMapper;
    this.doubleCardOfFlightMapper = doubleCardOfFlightMapper;
    this.informationCardMapper = informationCardMapper;
    this.itineraryService = itineraryService;
    this.dataService = dataService;
    this.filterOneWayService = filterOneWayService;
    this.filterMultipleService = filterMultipleService;
    this.userService = userService;
    this.legRepository = legRepository;
  }

  public List<SingleCardOfFlightDto> getListOfSingleCardOfFlight(String clientNumber) {
    logger.info("Get list of single card of flight");
    Itinerary itinerary = itineraryService.findItineraryByClientNumber(clientNumber);
    return itinerary.getLeg().stream()
        .filter(leg -> leg.getOutboundLegs().size() !=0)
        .map(singleCardOfFlightMapper::mapLegToDto).collect(
        Collectors.toList());
  }

  public SingleCardOfFlightDto getSingleCardOfFlight(String legId) {
    logger.info("Get single card of flight");
    Leg leg = legRepository.findByLegId(legId).get(0);
    return singleCardOfFlightMapper.mapLegToDto(leg);
  }

  public List<DoubleCardOfFlightDto> getListOfDoubleCardOfFlightDto(String clientNumber) {
    logger.info("Get list of double card of flight dto");
    Itinerary itinerary = itineraryService.findItineraryByClientNumber(clientNumber);
    return itinerary.getItineraryDetail().stream().map(
        doubleCardOfFlightMapper::mapItineraryDetailToDto).collect(
        Collectors.toList());
  }

  public InformationCardDto getInformationCard(String clientNumber){
    logger.info("Get information card");
    Itinerary itinerary = itineraryService.findItineraryByClientNumber(clientNumber);
    return informationCardMapper.mapQueryToDto(itinerary.getQuery());
  }

  public Boolean addItineraryToDataBase(String clientNumber, SearchForm searchForm)
      throws InterruptedException, UnirestException, IOException {
    logger.info("Add itinerary to data base");
    return dataService.saveItineraryToDataBase(clientNumber, searchForm);

  }

  public List<SingleCardOfFlightDto> getListOfFilteredSingleCardOfFlight(String clientNumber, FilterForm filterForm) {
    logger.info("Get list of filtered single card of flight");
    Itinerary itinerary = itineraryService.findItineraryByClientNumber(clientNumber);
    List<SingleCardOfFlightDto> unfiltredList = itinerary.getLeg().stream()
        .filter(leg -> leg.getOutboundLegs().size() !=0)
        .map(singleCardOfFlightMapper::mapLegToDto)
        .collect(
        Collectors.toList());
    return filterOneWayService.filtrResult(unfiltredList,filterForm);
  }

  public List<DoubleCardOfFlightDto> getListOfFilteredDoubleCardOfFlight(String clientNumber, FilterForm filterForm) {
    logger.info("Get list of filtered double card of flight");
    Itinerary itinerary = itineraryService.findItineraryByClientNumber(clientNumber);
    List<DoubleCardOfFlightDto> unfiltredList = itinerary.getItineraryDetail().stream().map(
        doubleCardOfFlightMapper::mapItineraryDetailToDto).collect(
        Collectors.toList());
    return filterMultipleService.filtrResult(unfiltredList,filterForm);
  }

  public List<String> getListOfUserFavouriteFlights(String userId){
    logger.info("Get list of user favourite flights");
    return userService.showListOfUserFavouriteFlights(userId);
  }
}
