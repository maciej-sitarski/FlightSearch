package com.sitarski.maciej.flightsearch.dao;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

  Optional<Itinerary> findByClientNumber (Long clientNumber);
  Optional<Itinerary> findByTime (LocalDateTime time);
}