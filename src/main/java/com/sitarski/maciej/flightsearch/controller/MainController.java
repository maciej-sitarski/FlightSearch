package com.sitarski.maciej.flightsearch.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.jsonApi.jsonPlacesApi.PlaceList;
import com.sitarski.maciej.flightsearch.parser.PlaceParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

  @RequestMapping("/home")
  public ModelAndView getMain() throws IOException, UnirestException {
    Map<String,Object> params = new HashMap<>();
    params.put("content", "main");
    return new ModelAndView("home", params);
  }
}
