package com.sitarski.maciej.flightsearch.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dao.ItineraryRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.jsonApi.jsonPlacesApi.PlaceList;
import com.sitarski.maciej.flightsearch.parser.PlaceParser;
import com.sitarski.maciej.flightsearch.service.ClientAttributionService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

  private final ClientAttributionService clientAttributionService;

  @Autowired
  public MainController(ClientAttributionService clientAttributionService) {
    this.clientAttributionService = clientAttributionService;
  }

  @GetMapping("/home")
  public ModelAndView getMain(HttpServletRequest req, HttpServletResponse resp) throws IOException, UnirestException {
    clientAttributionService.assignClientNumber(req);
    Map<String,Object> params = new HashMap<>();
    params.put("content", "main");
    return new ModelAndView("home", params);
  }
}
