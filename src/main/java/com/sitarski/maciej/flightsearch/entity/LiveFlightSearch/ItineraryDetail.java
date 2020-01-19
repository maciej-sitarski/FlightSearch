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

@Entity
@Table(name = "itinerary_detail")
public class ItineraryDetail {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "outboundLegId")
  private String outboundLegId;

  @Column(name = "inboundLegId")
  private String inboundLegId;

  @OneToMany(mappedBy = "itineraryDetail", cascade = CascadeType.ALL)
  private List<PriceOption> priceOptions = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "itinerary_id")
  private Itinerary itinerary;

  public ItineraryDetail() {
  }

  public ItineraryDetail(String outboundLegId, String inboundLegId) {
    this.outboundLegId = outboundLegId;
    this.inboundLegId = inboundLegId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOutboundLegId() {
    return outboundLegId;
  }

  public void setOutboundLegId(String outboundLegId) {
    this.outboundLegId = outboundLegId;
  }

  public String getInboundLegId() {
    return inboundLegId;
  }

  public void setInboundLegId(String inboundLegId) {
    this.inboundLegId = inboundLegId;
  }

  public List<PriceOption> getPriceOptions() {
    return priceOptions;
  }

  public void setPriceOptions(
      List<PriceOption> priceOptions) {
    this.priceOptions = priceOptions;
  }

  public Itinerary getItinerary() {
    return itinerary;
  }

  public void setItinerary(Itinerary itinerary) {
    this.itinerary = itinerary;
  }


}
