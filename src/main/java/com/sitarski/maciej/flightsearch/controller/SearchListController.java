package com.sitarski.maciej.flightsearch.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlight;
import com.sitarski.maciej.flightsearch.dto.QueryDto;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.SearchForm;
import com.sitarski.maciej.flightsearch.service.ClientAttributionService;
import com.sitarski.maciej.flightsearch.service.DataService;
import com.sitarski.maciej.flightsearch.service.ItineraryService;
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

  @Autowired
  public SearchListController(ClientAttributionService clientAttributionService,
      SearchListService searchListService) {

    this.clientAttributionService = clientAttributionService;
    this.searchListService = searchListService;
  }

  @GetMapping("/searchList")
  public ModelAndView getMain(HttpServletRequest req, SearchForm searchForm)
      throws IOException, UnirestException, InterruptedException {
    Map<String, Object> params = new HashMap<>();

    String clientNumber = clientAttributionService.assignClientNumber(req);

    searchListService.addItineraryToDataBase(clientNumber, searchForm);

    List<SingleCardOfFlight> singleCardOfFlightList = searchListService.getSingleCardOfFlight(clientNumber);
    QueryDto queryDto = searchListService.getQueryDto(clientNumber);

    params.put("legs", singleCardOfFlightList);
    params.put("query", queryDto);

    if (searchForm.getInboundDate() != null) {
      return new ModelAndView("searchListReturnFlight", params);
    } else {
      return new ModelAndView("searchList", params);
    }
  }
}

