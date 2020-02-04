package com.sitarski.maciej.flightsearch.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

  @GetMapping("/home")
  public ModelAndView getMain() {
    Map<String, Object> params = new HashMap<>();
    params.put("content", "main");
    return new ModelAndView("home", params);
  }
}
