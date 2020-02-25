package com.sitarski.maciej.flightsearch.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.service.HomeService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  private final HomeService homeService;

  @Autowired
  public HomeController(HomeService homeService) {
    this.homeService = homeService;
  }

  @GetMapping("/home")
  public ModelAndView getMain() {
    Map<String, Object> params = new HashMap<>();
    return new ModelAndView("home", params);
  }


  @RequestMapping(value="/originPlaceAutocomplete")
  public @ResponseBody
  List<String> getAutocompleteOriginPlaces(@RequestParam(value = "term") String place)
      throws IOException, UnirestException {
    return homeService.getAutocompletePlacesList(place);
  }

  @RequestMapping(value="/destinationPlaceAutocomplete")
  public @ResponseBody
  List<String> getAutocompleteDestinationPlaces(@RequestParam(value = "term") String place)
      throws IOException, UnirestException {
    return homeService.getAutocompletePlacesList(place);
  }
}
