package com.sitarski.maciej.flightsearch.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dao.UserRepository;
import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.entity.SearchForm;
import com.sitarski.maciej.flightsearch.entity.userManage.UserFavouriteFlight;
import com.sitarski.maciej.flightsearch.service.FavouriteFlightsService;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FavouriteFlightsController {

  private final UserRepository userRepository;
  private final FavouriteFlightsService favouriteFlightsService;

  @Autowired
  public FavouriteFlightsController(
      UserRepository userRepository,
      FavouriteFlightsService favouriteFlightsService) {
    this.userRepository = userRepository;
    this.favouriteFlightsService = favouriteFlightsService;
  }

  @GetMapping("/favouriteFlights")
  public ModelAndView getFavouriteFlights(Principal principal) {

    Map<String, Object> params = new HashMap<>();

    Long userId = Long.valueOf(principal.getName());

    List<UserFavouriteFlight> userFavouriteFlightList = userRepository.findByUserId(userId).get()
        .getUserFavouriteFlights();

    List<UserFavouriteFlight> userFavouriteFlightListAfterCheckingStatus = favouriteFlightsService.getListOfFavouriteFlightsAfterCheckingStatus(userFavouriteFlightList);

    if (userFavouriteFlightListAfterCheckingStatus.size() == 0) {
      params.put("noResult", "noResult");
    } else {
      SearchForm searchForm = favouriteFlightsService.getSearchForm(userFavouriteFlightListAfterCheckingStatus.get(0));
      List<SingleCardOfFlightDto> singleCardOfFlightDtoList = userFavouriteFlightListAfterCheckingStatus.stream()
          .map(userFavouriteFlight -> {
            try {
              return favouriteFlightsService.getSingleCardOfFavouriteFlightDto(userFavouriteFlight);
            } catch (InterruptedException | UnirestException | IOException e) {
              e.printStackTrace();
              return null;
            }
          })
          .collect(Collectors.toList());
      params.put("principal", principal);
      params.put("searchForm", searchForm);
      params.put("singleCardOfFlightList", singleCardOfFlightDtoList);
    }

    return new ModelAndView("favouriteFlights", params);
  }
}
