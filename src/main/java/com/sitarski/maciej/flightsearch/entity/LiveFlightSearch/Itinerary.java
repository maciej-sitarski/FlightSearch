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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import lombok.Data;

@Entity
@Data
@Table(name = "itinerary")
public class Itinerary {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "sessionKey")
  private String sessionKey;

  @Column(name = "status")
  private String status;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "query_id", unique = true)
  private Query query;

  @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
  private List<ItineraryDetail> itineraryDetail = new ArrayList<>();

  @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
  private List<Leg> leg = new ArrayList<>();

  @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
  private List<Currency> currency = new ArrayList<>();

  @Column(name = "clientNumber")
  private Long clientNumber;

  @Column(name = "accessTime")
  private LocalDateTime time;


}
