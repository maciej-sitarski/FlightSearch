package com.sitarski.maciej.flightsearch.entity.userManage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.ItineraryDetail;
import lombok.Data;

@Entity
@Data
@Table(name = "favouriteFlights")
public class UserFavouriteFlight {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "legId")
  private String legId;

  @Column(name = "originPlace")
  private String originPlace;

  @Column(name = "destinationPlace")
  private String destinationPlace;

  @Column(name = "outboundDate")
  private LocalDateTime outboundDate;

  @Column(name = "inboundDate")
  private LocalDate inboundDate;

  @Column(name = "transportClass")
  private String transportClass;

  @Column(name = "numberOfAdults")
  private Integer numberOfAdults;

  @Column(name = "numberOfChildren")
  private Integer numberOfChildren;

  @Column(name = "numberOfInfants")
  private Integer numberOfInfants;

  @ManyToMany(mappedBy = "userFavouriteFlights")
  private List<User> users = new ArrayList<>();

//  @OneToMany(mappedBy = "userFavouriteFlight", cascade = CascadeType.ALL)
//  private List<HistoryOfPricesFlights> historyOfPricesFlightsList = new ArrayList<>();

}
