package com.sitarski.maciej.flightsearch.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlight;
import com.sitarski.maciej.flightsearch.dto.QueryDto;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.SearchForm;
import com.sitarski.maciej.flightsearch.mapper.dtoMapper.LegDtoMapper;
import com.sitarski.maciej.flightsearch.mapper.dtoMapper.QueryDtoMapper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SearchListService {

  private final LegDtoMapper legDtoMapper;
  private final QueryDtoMapper queryDtoMapper;
  private final ItineraryService itineraryService;
  private final DataService dataService;


  public SearchListService(
      LegDtoMapper legDtoMapper,
      QueryDtoMapper queryDtoMapper,
      ItineraryService itineraryService,
      DataService dataService) {
    this.legDtoMapper = legDtoMapper;
    this.queryDtoMapper = queryDtoMapper;
    this.itineraryService = itineraryService;
    this.dataService = dataService;
  }

  public List<SingleCardOfFlight> getSingleCardOfFlight(String clientNumber){
    Itinerary itinerary = itineraryService.findItineraryByClientNumber(clientNumber);
    return itinerary.getLeg().stream().map(
        legDtoMapper::mapLegToDto).collect(
        Collectors.toList());
  }

  public QueryDto getQueryDto(String clientNumber){
    Itinerary itinerary = itineraryService.findItineraryByClientNumber(clientNumber);
    return queryDtoMapper.mapQueryToDto(itinerary.getQuery());
  }

  public void addItineraryToDataBase(String clientNumber, SearchForm searchForm)
      throws InterruptedException, UnirestException, IOException {
    dataService.saveItineraryToDataBase(clientNumber, searchForm);
  }
}
