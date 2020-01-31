package com.sitarski.maciej.flightsearch.dao;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Agent;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
  Optional<Agent> findByAgentId(Long id);
  List<Agent> findAllByItinerary(Itinerary  itinerary);
}
