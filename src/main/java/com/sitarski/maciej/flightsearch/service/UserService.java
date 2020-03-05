package com.sitarski.maciej.flightsearch.service;

import com.sitarski.maciej.flightsearch.dao.UserRepository;
import com.sitarski.maciej.flightsearch.entity.userManage.User;
import com.sitarski.maciej.flightsearch.entity.userManage.UserFavouriteFlight;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<String> showListOfUserFavouriteFlights(String userId){
    logger.info("Show list of user favourite flights");
    User user = userRepository.findByUserId(Long.valueOf(userId)).get();
    return user.getUserFavouriteFlights().stream().map(UserFavouriteFlight::getLegId).collect(
        Collectors.toList());
  }
}
