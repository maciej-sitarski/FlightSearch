package com.sitarski.maciej.flightsearch.entity.userManage;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "userId")
  private Long userId;

  @Column(name = "email")
  private String email;

  @ManyToMany
  @JoinTable(name = "user_userFavouriteFlights",
      joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "id_userFavouriteFlights", referencedColumnName = "id"))
  private List<UserFavouriteFlight> userFavouriteFlights = new ArrayList<>();
}
