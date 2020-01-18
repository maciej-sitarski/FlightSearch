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
@Table(name = "place")
public class Place {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "place_id")
  private Long place_id;

  @Column(name = "parentId")
  private Long parentId;

  @Column(name = "code")
  private String code;

  @Column(name = "type")
  private String type;

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "itinerary_id")
  private Itinerary itinerary;

  public Place() {
  }

  public Place(Long place_id, Long parentId, String code, String type, String name) {
    this.place_id = place_id;
    this.parentId = parentId;
    this.code = code;
    this.type = type;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPlace_id() {
    return place_id;
  }

  public void setPlace_id(Long place_id) {
    this.place_id = place_id;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Itinerary getItinerary() {
    return itinerary;
  }

  public void setItinerary(Itinerary itinerary) {
    this.itinerary = itinerary;
  }
}
