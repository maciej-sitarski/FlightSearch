package com.sitarski.maciej.flightsearch.controller;

import com.sitarski.maciej.flightsearch.dao.ItineraryRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

  private final ItineraryRepository itineraryRepository;

  @Autowired
  public FilterController(
      ItineraryRepository itineraryRepository) {
    this.itineraryRepository = itineraryRepository;
  }

  @GetMapping(value = "/filter/{id}")
  public Response addMop(@PathVariable("id") Long id, HttpServletRequest req) {

    Itinerary itinerary = itineraryRepository.findByClientNumber(id).orElse(null);

    for (int i = 0; i < itinerary.getLeg().size(); i++) {
      if (!itinerary.getLeg().get(i).getStops().isEmpty()) {
        itinerary.getLeg().remove(itinerary.getLeg().get(i));
      }
    }
    List<Leg> legs = itinerary.getLeg().stream()
        .filter(leg->leg.getStops().isEmpty())
        .collect(Collectors.toList());

    req.getSession().setAttribute("itinerary", itinerary);
    Itinerary dupa = (Itinerary) req.getSession().getAttribute("itinerary");
    return Response.ok().build();
  }

}
