package com.sitarski.maciej.flightsearch.entity.LiveFlightSearch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "query")
public class Query {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "country")
  private String country;

  @Column(name = "currency")
  private String currency;

  @Column(name = "locale")
  private String locale;

  @Column(name = "adults")
  private Long adults;

  @Column(name = "children")
  private Long children;

  @Column(name = "infants")
  private Long infants;

  @Column(name = "originPlace")
  private String originPlace;

  @Column(name = "destinationPlace")
  private String destinationPlace;

  @Column(name = "outboundDate")
  private String outboundDate;

  @Column(name = "inboundDate")
  private String inboundDate;

  @Column(name = "cabinClass")
  private String cabinClass;
}
