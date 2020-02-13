package com.sitarski.maciej.flightsearch.dao;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.PriceOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceOptionRepository extends JpaRepository<PriceOption, Long> {

}
