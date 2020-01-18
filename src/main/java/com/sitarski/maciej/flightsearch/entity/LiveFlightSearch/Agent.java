package com.sitarski.maciej.flightsearch.entity.LiveFlightSearch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
  private Long agent_id;

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

  public Agent() {
  }

  public Agent(Long agent_id, String name, String imageUrl, String status,
      Boolean optimisedForMobile, String type) {
    this.agent_id = agent_id;
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

  public Long getAgent_id() {
    return agent_id;
  }

  public void setAgent_id(Long agent_id) {
    this.agent_id = agent_id;
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
}
