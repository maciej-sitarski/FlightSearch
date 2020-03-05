package com.sitarski.maciej.flightsearch.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dto.DoubleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.dto.InformationCardDto;
import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.entity.FilterForm;
import com.sitarski.maciej.flightsearch.entity.SearchForm;
import com.sitarski.maciej.flightsearch.service.ClientAttributionService;
import com.sitarski.maciej.flightsearch.service.FilterOneWayService;
import com.sitarski.maciej.flightsearch.service.SearchListService;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchListController {

  private final ClientAttributionService clientAttributionService;
  private final SearchListService searchListService;
  private final FilterOneWayService filterOneWayService;

  @Autowired
  public SearchListController(ClientAttributionService clientAttributionService,
      SearchListService searchListService,
      FilterOneWayService filterOneWayService) {
    this.clientAttributionService = clientAttributionService;
    this.searchListService = searchListService;
    this.filterOneWayService = filterOneWayService;
  }

  @GetMapping("/searchList")
  public ModelAndView getSearchList(HttpServletRequest req, @Valid SearchForm searchForm,
      Errors errors,
      FilterForm filterForm, Principal principal)
      throws IOException, UnirestException, InterruptedException {

    if (errors.hasErrors()) {
      Map<String, Object> params = new HashMap<>();
      params.put("errors", errors);
      return new ModelAndView("home", params);
    } else {
      req.getSession().setAttribute("searchForm", searchForm);
      Map<String, Object> params = new HashMap<>();
      String clientNumber = clientAttributionService.assignClientNumber(req);
      if(searchListService.addItineraryToDataBase(clientNumber, searchForm)){
        filterForm.setDirect("on");
        filterForm.setOneStop("on");
        filterForm.setMoreStops("on");

        if (principal != null) {
          List<String> favouriteLegs = searchListService
              .getListOfUserFavouriteFlights(principal.getName());
          params.put("favouriteFlights", favouriteLegs);
          params.put("principal", principal);
        }

        if (searchForm.getInboundDate() != null) {
          List<DoubleCardOfFlightDto> doubleCardOfFlightDtoList = searchListService
              .getListOfDoubleCardOfFlightDto(clientNumber);
          InformationCardDto informationCardDto = searchListService.getInformationCard(clientNumber);

          params.put("filterForm", filterForm);
          params.put("doubleCardOfFlightList", doubleCardOfFlightDtoList);
          params.put("informationCard", informationCardDto);

          return new ModelAndView("searchListReturnFlight", params);

        } else {
          List<SingleCardOfFlightDto> singleCardOfFlightDtoList = filterOneWayService
              .sortedByOutboundDate(searchListService.getListOfSingleCardOfFlight(clientNumber));
          InformationCardDto informationCardDto = searchListService.getInformationCard(clientNumber);
          params.put("filterForm", filterForm);
          params.put("singleCardOfFlightList", singleCardOfFlightDtoList);
          params.put("informationCard", informationCardDto);
          params.put("searchForm", searchForm);

          return new ModelAndView("searchList", params);
        }
      } else {
        return new ModelAndView("noFlightsToShow", params);
      }
    }
  }

  @GetMapping("/oneWaySearchFilterList")
  public ModelAndView getFilterSearchList(HttpServletRequest req, FilterForm filterForm, Principal principal) {
    Map<String, Object> params = new HashMap<>();
    SearchForm searchForm = (SearchForm) req.getSession().getAttribute("searchForm");

    String clientNumber = filterForm.getClientNumber();
    List<SingleCardOfFlightDto> singleCardOfFlightDtoFiltredList = searchListService
        .getListOfFilteredSingleCardOfFlight(clientNumber, filterForm);
    InformationCardDto informationCardDto = searchListService.getInformationCard(clientNumber);

    if (principal != null) {
      List<String> favouriteLegs = searchListService
          .getListOfUserFavouriteFlights(principal.getName());
      params.put("favouriteFlights", favouriteLegs);
      params.put("principal", principal);
    }

    if (singleCardOfFlightDtoFiltredList.size() == 0) {
      List<SingleCardOfFlightDto> singleCardOfFlightDtoList = searchListService
          .getListOfSingleCardOfFlight(clientNumber);
      params.put("filterForm", filterForm);
      params.put("singleCardOfFlightList", singleCardOfFlightDtoList);
      params.put("informationCard", informationCardDto);
      return new ModelAndView("searchListNoResult", params);

    } else {
      params.put("filterForm", filterForm);
      params.put("singleCardOfFlightList", singleCardOfFlightDtoFiltredList);
      params.put("informationCard", informationCardDto);
      params.put("searchForm", searchForm);
      return new ModelAndView("searchList", params);
    }

  }

  @GetMapping("/returnSearchFilterList")
  public ModelAndView getFilterSearchListReturned(FilterForm filterForm) {
    Map<String, Object> params = new HashMap<>();

    String clientNumber = filterForm.getClientNumber();
    List<DoubleCardOfFlightDto> doubleCardOfFlightDtoFiltredList = searchListService
        .getListOfFilteredDoubleCardOfFlight(clientNumber, filterForm);
    InformationCardDto informationCardDto = searchListService.getInformationCard(clientNumber);

    if (doubleCardOfFlightDtoFiltredList.size() == 0) {
      List<DoubleCardOfFlightDto> doubleCardOfFlightDtoList = searchListService
          .getListOfDoubleCardOfFlightDto(clientNumber);
      params.put("filterForm", filterForm);
      params.put("doubleCardOfFlightList", doubleCardOfFlightDtoList);
      params.put("informationCard", informationCardDto);
      return new ModelAndView("searchListReturnFlightNoResult", params);

    } else {
      params.put("filterForm", filterForm);
      params.put("doubleCardOfFlightList", doubleCardOfFlightDtoFiltredList);
      params.put("informationCard", informationCardDto);
      return new ModelAndView("searchListReturnFlight", params);
    }
  }

  @GetMapping("/noFlightsToShow")
  public ModelAndView getNoFlightsSite(FilterForm filterForm) {
    Map<String, Object> params = new HashMap<>();
    return new ModelAndView("noFlightsToShow", params);
  }
}

