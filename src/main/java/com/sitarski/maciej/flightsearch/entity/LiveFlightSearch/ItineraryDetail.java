package com.sitarski.maciej.flightsearch.entity.LiveFlightSearch;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "itinerary_detail")
public class ItineraryDetail {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "outboundLeg_id")
  private Leg outboundLeg;

  @ManyToOne
  @JoinColumn(name = "inboundLeg_id")
  private Leg inboundLeg;

  @OneToMany(mappedBy = "itineraryDetail", cascade = CascadeType.ALL)
  private List<PriceOption> priceOptions = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "itinerary_id")
  private Itinerary itinerary;

  @Column(name = "clientNumber")
  private String clientNumber;


}
