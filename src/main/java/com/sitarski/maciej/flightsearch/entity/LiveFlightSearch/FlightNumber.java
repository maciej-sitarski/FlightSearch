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
import lombok.Data;

@Entity
@Data
@Table(name = "flight_number")
public class FlightNumber {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "flightNumber")
  private String flightNumber;

  @ManyToOne
  @JoinColumn(name = "carrier_id")
  private Carrier carrier;

  @ManyToOne
  @JoinColumn(name = "leg_id")
  private Leg leg;
}
