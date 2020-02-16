package com.sitarski.maciej.flightsearch.service;

import com.sitarski.maciej.flightsearch.dao.ItineraryRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientAttributionService {

  private final ItineraryRepository itineraryRepository;
  private final DataService dataService;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  public ClientAttributionService(ItineraryRepository itineraryRepository,
      DataService dataService) {
    this.itineraryRepository = itineraryRepository;
    this.dataService = dataService;
  }

  public String assignClientNumber(HttpServletRequest req) {
    logger.info("Client number assigned");
    String clientNumber;
    if (req.getSession().getAttribute("clientNumber") != null) {
      clientNumber = String.valueOf(req.getSession().getAttribute("clientNumber"));
      if (itineraryRepository.findByClientNumber(Long.valueOf(clientNumber)).isPresent()) {
        Itinerary itineraryToDelete = itineraryRepository
            .findByClientNumber(Long.valueOf(clientNumber)).orElse(null);
        dataService.deleteAgentsPlacesCarriersLegsFromDataBase(itineraryToDelete);
        return clientNumber;
      }
      return clientNumber;
    } else {
      long randomNumber = 0;
      do {
        randomNumber = (long) (Math.random() * 20000) + 1;
      } while (itineraryRepository.findByClientNumber(randomNumber).isPresent());
      req.getSession().setAttribute("clientNumber", randomNumber);
      return String.valueOf(randomNumber);
    }
  }
}
