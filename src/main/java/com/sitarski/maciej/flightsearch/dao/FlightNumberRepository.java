package com.sitarski.maciej.flightsearch.dao;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.FlightNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightNumberRepository extends JpaRepository<FlightNumber, Long> {

}
