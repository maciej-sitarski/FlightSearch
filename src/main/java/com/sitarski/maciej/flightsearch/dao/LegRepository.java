package com.sitarski.maciej.flightsearch.dao;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Leg;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegRepository extends JpaRepository<Leg, Long> {

  List<Leg> findByLegId(String id);

  List<Leg> findAllByClientNumber(String clientNumber);

  List<Leg> findAllByItinerary(Itinerary itinerary);

  List<Leg> findAllById(Long id);


}
