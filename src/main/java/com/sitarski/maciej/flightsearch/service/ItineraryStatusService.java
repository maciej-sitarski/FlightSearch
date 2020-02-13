package com.sitarski.maciej.flightsearch.service;

import com.sitarski.maciej.flightsearch.dao.AgentRepository;
import com.sitarski.maciej.flightsearch.dao.CarrierRepository;
import com.sitarski.maciej.flightsearch.dao.ItineraryRepository;
import com.sitarski.maciej.flightsearch.dao.PlaceRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Agent;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Carrier;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ItineraryStatusService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private final ItineraryRepository itineraryRepository;
  private final AgentRepository agentRepository;
  private final PlaceRepository placeRepository;
  private final CarrierRepository carrierRepository;

  @Autowired
  public ItineraryStatusService(ItineraryRepository itineraryRepository,
      AgentRepository agentRepository,
      PlaceRepository placeRepository,
      CarrierRepository carrierRepository) {
    this.itineraryRepository = itineraryRepository;
    this.agentRepository = agentRepository;
    this.placeRepository = placeRepository;
    this.carrierRepository = carrierRepository;
  }

  @Scheduled(fixedRate = 500000)
  public void checkStatusOfItinerary() {
    logger.info("Checking status of itinerary");
    LocalDateTime now = LocalDateTime.now();
    List<LocalDateTime> itineraryTimes = itineraryRepository.findAll().stream()
        .map(Itinerary::getTime).collect(
            Collectors.toList());
    for (int i = 0; i < itineraryTimes.size(); i++) {
      Duration duration = Duration.between(itineraryTimes.get(i), now);
      if (duration.getSeconds() > 300) {
        Itinerary itineraryToDelete = itineraryRepository.findByTime(itineraryTimes.get(i))
            .orElse(null);

        String clientNumber = itineraryToDelete.getClientNumber().toString();

        List<Agent> agentToDelete = agentRepository.findAllByClientNumber(clientNumber);
        agentToDelete.forEach(agentRepository::delete);

        List<Place> placeToDelete = placeRepository.findAllByClientNumber(clientNumber);
        placeToDelete.forEach(placeRepository::delete);

        List<Carrier> carriersToDelete = carrierRepository.findAllByClientNumber(clientNumber);
        carriersToDelete.forEach(carrierRepository::delete);

        itineraryRepository.delete(itineraryToDelete);
      }
    }
  }
}
