package com.sitarski.maciej.flightsearch.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dto.DoubleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.dto.InformationCardDto;
import com.sitarski.maciej.flightsearch.entity.FilterForm;
import com.sitarski.maciej.flightsearch.entity.SearchForm;
import com.sitarski.maciej.flightsearch.service.ClientAttributionService;
import com.sitarski.maciej.flightsearch.service.FilterService;
import com.sitarski.maciej.flightsearch.service.SearchListService;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchListController {

  private final ClientAttributionService clientAttributionService;
  private final SearchListService searchListService;
  private final FilterService filterService;

  @Autowired
  public SearchListController(ClientAttributionService clientAttributionService,
      SearchListService searchListService,
      FilterService filterService) {

    this.clientAttributionService = clientAttributionService;
    this.searchListService = searchListService;
    this.filterService = filterService;
  }

  @GetMapping("/searchList")
  public ModelAndView getSearchList(HttpServletRequest req, SearchForm searchForm, FilterForm filterForm)
      throws IOException, UnirestException, InterruptedException {
    Map<String, Object> params = new HashMap<>();

    String clientNumber = clientAttributionService.assignClientNumber(req);
    searchListService.addItineraryToDataBase(clientNumber, searchForm);

    if (searchForm.getInboundDate() != null) {
      List<DoubleCardOfFlightDto> doubleCardOfFlightDtoList = searchListService
          .getListOfDoubleCardOfFlightDto(clientNumber);
      InformationCardDto informationCardDto = searchListService.getInformationCard(clientNumber);

      params.put("filterForm", filterForm);
      params.put("doubleCardOfFlightList", doubleCardOfFlightDtoList);
      params.put("informationCard", informationCardDto);

      return new ModelAndView("searchListReturnFlight", params);

    } else {
      List<SingleCardOfFlightDto> singleCardOfFlightDtoList = filterService
          .sortedByOutboundDate(searchListService.getListOfSingleCardOfFlight(clientNumber));
      InformationCardDto informationCardDto = searchListService.getInformationCard(clientNumber);

      params.put("filterForm", filterForm);
      params.put("singleCardOfFlightList", singleCardOfFlightDtoList);
      params.put("informationCard", informationCardDto);

      return new ModelAndView("searchList", params);
    }
  }


  @GetMapping("/oneWaySearchFilterList")
  public ModelAndView getFilterSearchList(FilterForm filterForm) {
    Map<String, Object> params = new HashMap<>();

    String  clientNumber = filterForm.getClientNumber();
    List<SingleCardOfFlightDto> singleCardOfFlightDtoFiltredList = searchListService.getListOfFilteredSingleCardOfFlight(clientNumber, filterForm);
    InformationCardDto informationCardDto = searchListService.getInformationCard(clientNumber);

    if(singleCardOfFlightDtoFiltredList.size() == 0){
      List<SingleCardOfFlightDto> singleCardOfFlightDtoList = searchListService.getListOfSingleCardOfFlight(clientNumber);
      params.put("filterForm", filterForm);
      params.put("singleCardOfFlightList", singleCardOfFlightDtoList);
      params.put("informationCard", informationCardDto);
      return new ModelAndView("noResultTemplate", params);

    } else {
      params.put("filterForm", filterForm);
      params.put("singleCardOfFlightList", singleCardOfFlightDtoFiltredList);
      params.put("informationCard", informationCardDto);
      return new ModelAndView("searchList", params);
    }

  }

//  @GetMapping("/returnSearchFilterList")
//  public ModelAndView getFilterSearchList(FilterForm filterForm) {
//    Map<String, Object> params = new HashMap<>();
//
//
//    if (searchForm.getInboundDate() != null) {
//      List<DoubleCardOfFlightDto> doubleCardOfFlightDtoList = searchListService.getDoubleCardOfFlightDto(clientNumber);
//      InformationCardDto informationCardDto = searchListService.getInformationCard(clientNumber);
//
//      params.put("doubleCardOfFlightList", doubleCardOfFlightDtoList);
//      params.put("informationCard", informationCardDto);
//
//      return new ModelAndView("searchListReturnFlight", params);
//
//    } else {
//      List<SingleCardOfFlightDto> singleCardOfFlightDtoList = filterService
//          .sortedByOutboundDate(searchListService.getSingleCardOfFlight(clientNumber));
//      InformationCardDto informationCardDto = searchListService.getInformationCard(clientNumber);
//
//      params.put("singleCardOfFlightList", singleCardOfFlightDtoList);
//      params.put("informationCard", informationCardDto);
//
//      return new ModelAndView("searchList", params);
//    }
//  }
}

