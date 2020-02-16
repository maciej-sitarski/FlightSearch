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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import lombok.Data;

@Entity
@Data
@Table(name = "carrier")
public class Carrier {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "carrier_id")
  private Long carrierId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "imageUrl")
  private String imageUrl;

  @Column(name = "displayCode")
  private String displayCode;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "carrier_leg",
      joinColumns = @JoinColumn(name = "id_carrier", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "id_leg", referencedColumnName = "id"))
  private List<Leg> legs = new ArrayList<>();

  @OneToMany(mappedBy = "carrier", cascade = CascadeType.ALL)
  private List<FlightNumber> flightNumbers = new ArrayList<>();

  @Column(name = "clientNumber")
  private String clientNumber;
}
