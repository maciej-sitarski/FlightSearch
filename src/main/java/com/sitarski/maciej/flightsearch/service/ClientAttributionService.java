package com.sitarski.maciej.flightsearch.service;

import com.sitarski.maciej.flightsearch.dao.AgentRepository;
import com.sitarski.maciej.flightsearch.dao.CarrierRepository;
import com.sitarski.maciej.flightsearch.dao.ItineraryRepository;
import com.sitarski.maciej.flightsearch.dao.PlaceRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Agent;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Carrier;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.ItineraryApi;
import com.sitarski.maciej.flightsearch.mapper.AgentMapper;
import com.sitarski.maciej.flightsearch.mapper.CarrierMapper;
import com.sitarski.maciej.flightsearch.mapper.ItineraryMapper;
import com.sitarski.maciej.flightsearch.mapper.PlaceMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientAttributionService {

  private final ItineraryRepository itineraryRepository;
  private final AgentMapper agentMapper;
  private final CarrierMapper carrierMapper;
  private final PlaceMapper placeMapper;
  private final AgentRepository agentRepository;
  private final PlaceRepository placeRepository;
  private final CarrierRepository carrierRepository;
  private final ItineraryMapper itineraryMapper;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  public ClientAttributionService(ItineraryRepository itineraryRepository,
      AgentMapper agentMapper, CarrierMapper carrierMapper,
      PlaceMapper placeMapper, AgentRepository agentRepository,
      PlaceRepository placeRepository,
      CarrierRepository carrierRepository,
      ItineraryMapper itineraryMapper) {
    this.itineraryRepository = itineraryRepository;
    this.agentMapper = agentMapper;
    this.carrierMapper = carrierMapper;
    this.placeMapper = placeMapper;
    this.agentRepository = agentRepository;
    this.placeRepository = placeRepository;
    this.carrierRepository = carrierRepository;
    this.itineraryMapper = itineraryMapper;
  }

  public String assignClientNumber(HttpServletRequest req) {
    logger.info("Client number assigned");
    String clientNumber;
    if (req.getSession().getAttribute("clientNumber") != null) {
      clientNumber = String.valueOf(req.getSession().getAttribute("clientNumber"));
      if (itineraryRepository.findByClientNumber(Long.valueOf(clientNumber)).isPresent()) {
        Itinerary itineraryToDelete = itineraryRepository
            .findByClientNumber(Long.valueOf(clientNumber)).orElse(null);

        List<Agent> agentToDelete = agentRepository.findAllByItinerary(itineraryToDelete);
        agentToDelete.forEach(agentRepository::delete);

        List<Agent> agentNullToDelete = agentRepository.findAllByItinerary(null);
        agentNullToDelete.forEach(agentRepository::delete);

        List<Place> placeToDelete = placeRepository.findAllByItinerary(itineraryToDelete);
        placeToDelete.forEach(placeRepository::delete);

        List<Place> placeNullToDelete = placeRepository.findAllByItinerary(null);
        placeNullToDelete.forEach(placeRepository::delete);

        List<Carrier> carriersToDelete = carrierRepository.findAllByItinerary(itineraryToDelete);
        carriersToDelete.forEach(carrierRepository::delete);

        List<Carrier> carriersNullToDelete = carrierRepository.findAllByItinerary(null);
        carriersNullToDelete.forEach(carrierRepository::delete);

        itineraryRepository.delete(itineraryToDelete);
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

  public void saveItineraryToDataBase(ItineraryApi itineraryApi, String clientNumber) {
    logger.info("Itineraty save in data base");
    List<Agent> agents = itineraryApi.getAgentApi().stream().map(agentMapper::mapAgentApiToEntity)
        .collect(
            Collectors.toList());
    List<Carrier> carriers = itineraryApi.getCarrierApi().stream()
        .map(carrierMapper::mapCarrierApiToEntity).collect(
            Collectors.toList());
    List<Place> places = itineraryApi.getPlaceApi().stream().map(placeMapper::mapPlaceApiToEntity)
        .collect(
            Collectors.toList());
    agentRepository.saveAll(agents);
    carrierRepository.saveAll(carriers);
    placeRepository.saveAll(places);
    Itinerary itinerary = itineraryMapper.mapItineraryApiToEntity(itineraryApi);
    itinerary.setClientNumber(Long.valueOf(clientNumber));

    LocalDateTime now = LocalDateTime.now();
    itinerary.setTime(now);
    itineraryRepository.save(itinerary);
  }
}
