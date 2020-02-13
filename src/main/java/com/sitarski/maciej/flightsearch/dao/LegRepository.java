package com.sitarski.maciej.flightsearch.dao;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegRepository extends JpaRepository<Leg, String> {

  Optional<Leg> findByLegId(String id);

  List<Leg> findAllByClientNumber(String clientNumber);

  List<Leg> findAllByItinerary(Itinerary itinerary);

}
