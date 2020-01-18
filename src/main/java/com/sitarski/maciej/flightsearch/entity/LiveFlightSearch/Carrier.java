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
@Table(name = "carrier")
public class Carrier {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "carrier_id")
  private Long carrier_id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "imageUrl")
  private String imageUrl;

  @Column(name = "displayCode")
  private String displayCode;

  @ManyToOne
  @JoinColumn(name = "itinerary_id")
  private Itinerary itinerary;

  public Carrier() {
  }

  public Carrier(Long carrier_id, String code, String name, String imageUrl,
      String displayCode) {
    this.carrier_id = carrier_id;
    this.code = code;
    this.name = name;
    this.imageUrl = imageUrl;
    this.displayCode = displayCode;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCarrier_id() {
    return carrier_id;
  }

  public void setCarrier_id(Long carrier_id) {
    this.carrier_id = carrier_id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
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

  public String getDisplayCode() {
    return displayCode;
  }

  public void setDisplayCode(String displayCode) {
    this.displayCode = displayCode;
  }

  public Itinerary getItinerary() {
    return itinerary;
  }

  public void setItinerary(Itinerary itinerary) {
    this.itinerary = itinerary;
  }
}
