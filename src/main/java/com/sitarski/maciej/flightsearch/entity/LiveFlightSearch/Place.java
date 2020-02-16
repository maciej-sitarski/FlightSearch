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
import lombok.Data;

@Entity
@Data
@Table(name = "place")
public class Place {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "place_id")
  private Long placeId;

  @Column(name = "parentId")
  private Long parentId;

  @Column(name = "code")
  private String code;

  @Column(name = "type")
  private String type;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "originStation", cascade = CascadeType.ALL)
  private List<Leg> originStations = new ArrayList<>();

  @OneToMany(mappedBy = "destinationStation", cascade = CascadeType.ALL)
  private List<Leg> destinationStations = new ArrayList<>();

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "place_leg",
      joinColumns = @JoinColumn(name = "id_place", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "id_leg", referencedColumnName = "id"))
  private List<Leg> legs = new ArrayList<>();

  @Column(name = "clientNumber")
  private String clientNumber;
}
