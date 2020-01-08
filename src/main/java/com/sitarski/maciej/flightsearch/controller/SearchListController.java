package com.sitarski.maciej.flightsearch.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchListController {

  @GetMapping("/searchList")
  public ModelAndView getMain() throws IOException, UnirestException {
    Map<String,Object> params = new HashMap<>();
    params.put("content", "main");
    return new ModelAndView("searchList", params);
  }
}
