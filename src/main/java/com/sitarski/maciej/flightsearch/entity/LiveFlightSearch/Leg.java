package com.sitarski.maciej.flightsearch.entity.LiveFlightSearch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import lombok.Data;

@Entity
@Data
@Table(name = "leg")
public class Leg {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "legId")
  private String legId;

  @ManyToOne
  @JoinColumn(name = "originStation_id")
  private Place originStation;

  @ManyToOne
  @JoinColumn(name = "destinationStation_id")
  private Place destinationStation;

  @Column(name = "departure")
  private LocalDateTime departure;

  @Column(name = "arrival")
  private LocalDateTime arrival;

  @Column(name = "duration")
  private Long duration;

  @Column(name = "journeyMode")
  private String journeyMode;

  @Column(name = "directionality")
  private String directionality;

  @OneToMany(mappedBy = "leg", cascade = CascadeType.ALL)
  private List<FlightNumber> flightNumbers = new ArrayList<>();

  @ManyToMany(mappedBy = "legs", cascade = CascadeType.MERGE)
  private List<Carrier> carriers;

  @ManyToMany(mappedBy = "legs", cascade = CascadeType.MERGE)
  private List<Place> stops;

  @ManyToOne
  @JoinColumn(name = "itinerary_id")
  private Itinerary itinerary;

  @OneToMany(mappedBy = "outboundLeg", cascade = CascadeType.ALL)
  private List<ItineraryDetail> outboundLegs = new ArrayList<>();

  @OneToMany(mappedBy = "inboundLeg", cascade = CascadeType.ALL)
  private List<ItineraryDetail> inboundLegs = new ArrayList<>();

  @Column(name = "clientNumber")
  private String clientNumber;
}
