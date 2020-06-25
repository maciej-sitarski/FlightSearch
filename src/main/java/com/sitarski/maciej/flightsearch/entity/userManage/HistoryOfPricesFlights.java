//package com.sitarski.maciej.flightsearch.entity.userManage;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Entity
//@Data
//@Table(name = "historyOfPrices")
//public class HistoryOfPricesFlights {
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "price")
//    private Float price;
//
//    @ManyToOne
//    @JoinColumn(name = "favouriteFlight_id")
//    private UserFavouriteFlight userFavouriteFlight;
//
//}
