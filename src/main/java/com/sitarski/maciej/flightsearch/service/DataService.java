package com.sitarski.maciej.flightsearch.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dao.AgentRepository;
import com.sitarski.maciej.flightsearch.dao.CarrierRepository;
import com.sitarski.maciej.flightsearch.dao.ItineraryDetailsRepository;
import com.sitarski.maciej.flightsearch.dao.ItineraryRepository;
import com.sitarski.maciej.flightsearch.dao.LegRepository;
import com.sitarski.maciej.flightsearch.dao.PlaceRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Agent;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Carrier;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.ItineraryDetail;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import com.sitarski.maciej.flightsearch.entity.SearchForm;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.ItineraryApi;
import com.sitarski.maciej.flightsearch.mapper.AgentMapper;
import com.sitarski.maciej.flightsearch.mapper.CarrierMapper;
import com.sitarski.maciej.flightsearch.mapper.ItineraryDetailMapper;
import com.sitarski.maciej.flightsearch.mapper.ItineraryMapper;
import com.sitarski.maciej.flightsearch.mapper.LegMapper;
import com.sitarski.maciej.flightsearch.mapper.PlaceMapper;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

  private final ItineraryRepository itineraryRepository;
  private final AgentMapper agentMapper;
  private final CarrierMapper carrierMapper;
  private final PlaceMapper placeMapper;
  private final AgentRepository agentRepository;
  private final PlaceRepository placeRepository;
  private final CarrierRepository carrierRepository;
  private final ItineraryMapper itineraryMapper;
  private final ItineraryDetailMapper itineraryDetailMapper;
  private final ItineraryDetailsRepository itineraryDetailsRepository;
  private final LegMapper legMapper;
  private final LegRepository legRepository;
  private final ItineraryService itineraryService;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  public DataService(ItineraryRepository itineraryRepository,
      AgentMapper agentMapper,
      CarrierMapper carrierMapper, PlaceMapper placeMapper,
      AgentRepository agentRepository,
      PlaceRepository placeRepository,
      CarrierRepository carrierRepository,
      ItineraryMapper itineraryMapper,
      ItineraryDetailMapper itineraryDetailMapper,
      ItineraryDetailsRepository itineraryDetailsRepository,
      LegMapper legMapper, LegRepository legRepository,
      ItineraryService itineraryService) {
    this.itineraryRepository = itineraryRepository;
    this.agentMapper = agentMapper;
    this.carrierMapper = carrierMapper;
    this.placeMapper = placeMapper;
    this.agentRepository = agentRepository;
    this.placeRepository = placeRepository;
    this.carrierRepository = carrierRepository;
    this.itineraryMapper = itineraryMapper;
    this.itineraryDetailMapper = itineraryDetailMapper;
    this.itineraryDetailsRepository = itineraryDetailsRepository;
    this.legMapper = legMapper;
    this.legRepository = legRepository;
    this.itineraryService = itineraryService;
  }

  public Boolean saveItineraryToDataBase(String clientNumber,  SearchForm searchForm)
      throws InterruptedException, UnirestException, IOException {

    logger.info("Itineraty save in data base");

    Boolean correctFinding = true;
    ItineraryApi itineraryApi = itineraryService.getItineraryApi(searchForm);
    if(itineraryApi == null){
      correctFinding = false;
      return correctFinding;
    }

    saveDataToDataBase(itineraryApi, clientNumber);

    Itinerary itinerary = itineraryMapper.mapItineraryApiToEntity(itineraryApi, clientNumber);

    itinerary.setClientNumber(Long.valueOf(clientNumber));
    LocalDateTime now = LocalDateTime.now();
    itinerary.setTime(now);
    itineraryRepository.save(itinerary);
    return correctFinding;
  }

  private void saveDataToDataBase(ItineraryApi itineraryApi, String clientNumber) {
    logger.info("Data save in data base");
    List<Agent> agents = itineraryApi.getAgentApi().stream().map(agentMapper::mapAgentApiToEntity)
        .collect(
            Collectors.toList());
    agents.forEach(agent -> agent.setClientNumber(clientNumber));
    agentRepository.saveAll(agents);

    List<Carrier> carriers = itineraryApi.getCarrierApi().stream()
        .map(carrierMapper::mapCarrierApiToEntity).collect(
            Collectors.toList());
    carriers.forEach(carrier -> carrier.setClientNumber(clientNumber));
    carrierRepository.saveAll(carriers);

    List<Place> places = itineraryApi.getPlaceApi().stream().map(placeMapper::mapPlaceApiToEntity)
        .collect(
            Collectors.toList());
    places.forEach(place -> place.setClientNumber(clientNumber));
    placeRepository.saveAll(places);

    List<Leg> legs = itineraryApi.getLegApi().stream().map(legMapper::mapLegApiToEntity).collect(
        Collectors.toList());
    legs.forEach(leg -> leg.setClientNumber(clientNumber));
    legRepository.saveAll(legs);

    List<ItineraryDetail> itineraryDetails = itineraryApi.getItineraryDetailApi().stream()
        .map(itineraryDetailMapper::mapItineraryDetailApiToEntity).collect(
            Collectors.toList());
    itineraryDetails.forEach(itineraryDetail -> itineraryDetail.setClientNumber(clientNumber));
    itineraryDetailsRepository.saveAll(itineraryDetails);
  }

  public void deleteAgentsPlacesCarriersLegsFromDataBase(Itinerary itineraryToDelete) {

    logger.info("Delete data from data base");

    List<Agent> agentToDelete = agentRepository.findAllByClientNumber(itineraryToDelete.getClientNumber().toString());
    agentToDelete.forEach(agentRepository::delete);

    List<Place> placeToDelete = placeRepository.findAllByClientNumber(itineraryToDelete.getClientNumber().toString());
    placeToDelete.forEach(placeRepository::delete);

    List<Carrier> carriersToDelete = carrierRepository.findAllByClientNumber(itineraryToDelete.getClientNumber().toString());
    carriersToDelete.forEach(carrierRepository::delete);

    List<Leg> legsToDelete = legRepository.findAllByItinerary(itineraryToDelete);
    legsToDelete.forEach(legRepository::delete);

    itineraryRepository.delete(itineraryToDelete);
  }

}
