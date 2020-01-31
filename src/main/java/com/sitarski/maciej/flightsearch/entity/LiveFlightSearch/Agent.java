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

@Entity
@Table(name = "agent")
public class Agent {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "agent_id")
  private Long agentId;

  @Column(name = "name")
  private String name;

  @Column(name = "imageUrl")
  private String imageUrl;

  @Column(name = "status")
  private String status;

  @Column(name = "optimisedForMobile")
  private Boolean optimisedForMobile;

  @Column(name = "type")
  private String type;

  @ManyToOne
  @JoinColumn(name = "itinerary_id")
  private Itinerary itinerary;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "agent_priceOption",
      joinColumns = @JoinColumn(name = "id_agent", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "id_priceOption", referencedColumnName = "id"))
  List<PriceOption> priceOptions = new ArrayList<>();

  public Agent() {
  }

  public Agent(Long agentId, String name, String imageUrl, String status,
      Boolean optimisedForMobile, String type) {
    this.agentId = agentId;
    this.name = name;
    this.imageUrl = imageUrl;
    this.status = status;
    this.optimisedForMobile = optimisedForMobile;
    this.type = type;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAgentId() {
    return agentId;
  }

  public void setAgentId(Long agentId) {
    this.agentId = agentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Boolean getOptimisedForMobile() {
    return optimisedForMobile;
  }

  public void setOptimisedForMobile(Boolean optimisedForMobile) {
    this.optimisedForMobile = optimisedForMobile;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Itinerary getItinerary() {
    return itinerary;
  }

  public void setItinerary(Itinerary itinerary) {
    this.itinerary = itinerary;
  }

  public List<PriceOption> getPriceOptions() {
    return priceOptions;
  }

  public void setPriceOptions(
      List<PriceOption> priceOptions) {
    this.priceOptions = priceOptions;
  }
}
