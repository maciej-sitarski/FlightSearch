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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "price_option")
public class PriceOption {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "price")
  private Float price;

  @Column(name = "linkUrl", length = 1200)
  private String linkUrl;

  @ManyToMany(mappedBy = "priceOptions", cascade = CascadeType.ALL)
  private List<Agent> agents;

  @ManyToOne
  @JoinColumn(name = "itinerary_detail_id")
  private ItineraryDetail itineraryDetail;

  public PriceOption() {
  }

  public PriceOption(Float price, String linkUrl) {
    this.price = price;
    this.linkUrl = linkUrl;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getLinkUrl() {
    return linkUrl;
  }

  public void setLinkUrl(String linkUrl) {
    this.linkUrl = linkUrl;
  }

  public ItineraryDetail getItineraryDetail() {
    return itineraryDetail;
  }

  public void setItineraryDetail(
      ItineraryDetail itineraryDetail) {
    this.itineraryDetail = itineraryDetail;
  }

  public List<Agent> getAgents() {
    return agents;
  }

  public void setAgents(
      List<Agent> agents) {
    this.agents = agents;
  }
}
