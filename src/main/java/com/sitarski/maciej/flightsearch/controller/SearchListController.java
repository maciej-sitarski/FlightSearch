package com.sitarski.maciej.flightsearch.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.entity.ItineraryInquiry;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.Itinerary;
import com.sitarski.maciej.flightsearch.parser.LiveFlightSearchParser;
import com.sitarski.maciej.flightsearch.parser.LocalisationParser;
import com.sitarski.maciej.flightsearch.service.StringFormatService;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchListController {

  @Autowired
  LiveFlightSearchParser liveFlightSearchParser;

  @Autowired
  StringFormatService stringFormatService;

  @Autowired
  LocalisationParser localisationParser;

  @GetMapping("/searchList")
  public ModelAndView getMain(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, UnirestException, ParseException, InterruptedException {
    Map<String, Object> params = new HashMap<>();

    String originPlace = stringFormatService.formatStringPlaceToParse(req.getParameter("from"));
    String destinationPlace = stringFormatService.formatStringPlaceToParse(req.getParameter("to"));
    String outboundDate = req.getParameter("outboundDate");
    String inboundDate = req.getParameter("inboundDate");
    String transportClass = req.getParameter("class");
    String numOfAdults = req.getParameter("numberOfAdults");
    String numOfChildren = req.getParameter("numberOfChildren");
    String numOfInfants = req.getParameter("numberOfInfants");

    params.put("originPlace", req.getParameter("from"));
    params.put("destinationPlace", req.getParameter("to"));
    params.put("outboundDate", outboundDate);
    if(inboundDate != null){
      params.put("inboundDate", inboundDate);
    }
    params.put("transportClass", transportClass);
    params.put("numOfAdults", numOfAdults);
    params.put("numOfChildren", numOfChildren);
    params.put("numOfInfants", numOfInfants);

    ItineraryInquiry itineraryInquiry = new ItineraryInquiry.Builder()
        .originPlace(originPlace)
        .destinationPlace(destinationPlace)
        .outboundDate(outboundDate)
        .inboundDate(inboundDate)
        .transportClass(transportClass)
        .numOfAdults(numOfAdults)
        .numOfChildren(numOfChildren)
        .numOfInfants(numOfInfants)
        .build();

    Itinerary itinerary = liveFlightSearchParser.parseItinerary(itineraryInquiry);
    params.put("itineraries", itinerary);

    return new ModelAndView("searchList", params);
  }
}
