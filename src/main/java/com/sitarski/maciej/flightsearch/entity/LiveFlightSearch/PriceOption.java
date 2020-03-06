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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "price_option")
public class PriceOption {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "price")
  private Float price;

  @Column(name = "linkUrl", length = 2000)
  private String linkUrl;

  @ManyToMany(mappedBy = "priceOptions", cascade = CascadeType.MERGE)
  List<Agent> agents;

  @ManyToOne
  @JoinColumn(name = "itinerary_detail_id")
  private ItineraryDetail itineraryDetail;
}
