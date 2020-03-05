package com.sitarski.maciej.flightsearch.dao;

import com.sitarski.maciej.flightsearch.entity.userManage.UserFavouriteFlight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFavouriteFlightRepository extends JpaRepository<UserFavouriteFlight, Long> {

}
