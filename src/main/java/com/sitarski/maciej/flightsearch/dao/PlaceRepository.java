package com.sitarski.maciej.flightsearch.dao;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Carrier;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Itinerary;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Place;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

  Optional<Place> findByPlaceId(Long id);
  List<Place> findAllByItinerary(Itinerary itinerary);

}
