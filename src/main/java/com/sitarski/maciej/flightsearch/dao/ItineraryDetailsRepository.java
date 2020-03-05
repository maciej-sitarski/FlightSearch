package com.sitarski.maciej.flightsearch.dao;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.ItineraryDetail;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryDetailsRepository extends JpaRepository<ItineraryDetail, Long> {

  Optional<ItineraryDetail> findByOutboundLegId(Long legId);

  List<ItineraryDetail> findAllByClientNumber(String clientNumber);

  List<ItineraryDetail> findAllByOutboundLegId(Long legId);

  List<ItineraryDetail> findAllByOutboundLegIdAndInboundLegId(Long ouboundLegId, Long inboundLegId);
}
