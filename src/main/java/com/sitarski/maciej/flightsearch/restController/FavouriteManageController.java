package com.sitarski.maciej.flightsearch.restController;

import com.sitarski.maciej.flightsearch.dao.UserFavouriteFlightRepository;
import com.sitarski.maciej.flightsearch.dao.UserRepository;
import com.sitarski.maciej.flightsearch.entity.UserFavouriteSearchForm;
import com.sitarski.maciej.flightsearch.entity.userManage.User;
import com.sitarski.maciej.flightsearch.entity.userManage.UserFavouriteFlight;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favouriteManage")
public class FavouriteManageController {

  private final UserRepository userRepository;
  private final UserFavouriteFlightRepository userFavouriteFlightRepository;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  public FavouriteManageController(UserRepository userRepository,
      UserFavouriteFlightRepository userFavouriteFlightRepository) {
    this.userRepository = userRepository;
    this.userFavouriteFlightRepository = userFavouriteFlightRepository;
  }

  @PostMapping(value = "/save", consumes = "application/json")
  public @ResponseBody
  Response saveFavouriteFlightInDataBase(
      @RequestBody UserFavouriteSearchForm userFavouriteSearchForm) {

    logger.info("Favourite flight save in data base");

    UserFavouriteFlight userFavouriteFlight = new UserFavouriteFlight();

    userFavouriteFlight.setLegId(userFavouriteSearchForm.getLegId());
    userFavouriteFlight.setOriginPlace(userFavouriteSearchForm.getSearchForm().getOriginPlace());
    userFavouriteFlight
        .setDestinationPlace(userFavouriteSearchForm.getSearchForm().getDestinationPlace());
    userFavouriteFlight.setOutboundDate(userFavouriteSearchForm.getSearchForm().getOutboundDate());
    userFavouriteFlight.setInboundDate(userFavouriteSearchForm.getSearchForm().getInboundDate());
    userFavouriteFlight
        .setTransportClass(userFavouriteSearchForm.getSearchForm().getTransportClass());
    userFavouriteFlight
        .setNumberOfAdults(userFavouriteSearchForm.getSearchForm().getNumberOfAdults());
    userFavouriteFlight
        .setNumberOfChildren(userFavouriteSearchForm.getSearchForm().getNumberOfChildren());
    userFavouriteFlight
        .setNumberOfInfants(userFavouriteSearchForm.getSearchForm().getNumberOfInfants());

    User user = userRepository.findByUserId(Long.valueOf(userFavouriteSearchForm.getUserId()))
        .get();
    userFavouriteFlight.getUsers().add(user);
    user.getUserFavouriteFlights().add(userFavouriteFlight);

    userFavouriteFlightRepository.save(userFavouriteFlight);
    return Response.ok().build();
  }

  @PostMapping(value = "/delete", consumes = "application/json")
  public @ResponseBody
  Response deleteFavouriteFlightFromDataBase(
      @RequestBody UserFavouriteSearchForm userFavouriteSearchForm) {

    logger.info("Favourite flight delete from data base");

    UserFavouriteFlight userFavouriteFlightToDelete = userRepository
        .findByUserId(Long.valueOf(userFavouriteSearchForm.getUserId()))
        .get().getUserFavouriteFlights().stream().filter(userFavouriteFlight -> userFavouriteFlight
            .getLegId().equals(userFavouriteSearchForm.getLegId())).findFirst().get();
    userFavouriteFlightRepository.delete(userFavouriteFlightToDelete);

    return Response.ok().build();
  }
}
