package com.sitarski.maciej.flightsearch.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dto.DoubleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.dto.InformationCardDto;
import com.sitarski.maciej.flightsearch.entity.FilterForm;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.SearchForm;
import com.sitarski.maciej.flightsearch.mapper.dtoMapper.DoubleCardOfFlightMapper;
import com.sitarski.maciej.flightsearch.mapper.dtoMapper.InformationCardMapper;
import com.sitarski.maciej.flightsearch.mapper.dtoMapper.SingleCardOfFlightMapper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
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

  @Autowired
  public SearchListService(
      SingleCardOfFlightMapper singleCardOfFlightMapper,
      DoubleCardOfFlightMapper doubleCardOfFlightMapper,
      InformationCardMapper informationCardMapper,
      ItineraryService itineraryService,
      DataService dataService, FilterOneWayService filterOneWayService,
      FilterMultipleService filterMultipleService) {
    this.singleCardOfFlightMapper = singleCardOfFlightMapper;
    this.doubleCardOfFlightMapper = doubleCardOfFlightMapper;
    this.informationCardMapper = informationCardMapper;
    this.itineraryService = itineraryService;
    this.dataService = dataService;
    this.filterOneWayService = filterOneWayService;
    this.filterMultipleService = filterMultipleService;
  }

  public List<SingleCardOfFlightDto> getListOfSingleCardOfFlight(String clientNumber) {
    Itinerary itinerary = itineraryService.findItineraryByClientNumber(clientNumber);
    return itinerary.getLeg().stream().map(
        singleCardOfFlightMapper::mapLegToDto).collect(
        Collectors.toList());
  }

  public List<DoubleCardOfFlightDto> getListOfDoubleCardOfFlightDto(String clientNumber) {
    Itinerary itinerary = itineraryService.findItineraryByClientNumber(clientNumber);
    return itinerary.getItineraryDetail().stream().map(
        doubleCardOfFlightMapper::mapItineraryDetailToDto).collect(
        Collectors.toList());
  }

  public InformationCardDto getInformationCard(String clientNumber){
    Itinerary itinerary = itineraryService.findItineraryByClientNumber(clientNumber);
    return informationCardMapper.mapQueryToDto(itinerary.getQuery());
  }

  public void addItineraryToDataBase(String clientNumber, SearchForm searchForm)
      throws InterruptedException, UnirestException, IOException {
    dataService.saveItineraryToDataBase(clientNumber, searchForm);
  }

  public List<SingleCardOfFlightDto> getListOfFilteredSingleCardOfFlight(String clientNumber, FilterForm filterForm) {
    Itinerary itinerary = itineraryService.findItineraryByClientNumber(clientNumber);
    List<SingleCardOfFlightDto> unfiltredList = itinerary.getLeg().stream().map(
        singleCardOfFlightMapper::mapLegToDto).collect(
        Collectors.toList());
    return filterOneWayService.filtrResult(unfiltredList,filterForm);
  }

  public List<DoubleCardOfFlightDto> getListOfFilteredDoubleCardOfFlight(String clientNumber, FilterForm filterForm) {
    Itinerary itinerary = itineraryService.findItineraryByClientNumber(clientNumber);
    List<DoubleCardOfFlightDto> unfiltredList = itinerary.getItineraryDetail().stream().map(
        doubleCardOfFlightMapper::mapItineraryDetailToDto).collect(
        Collectors.toList());
    return filterMultipleService.filtrResult(unfiltredList,filterForm);
  }
}
