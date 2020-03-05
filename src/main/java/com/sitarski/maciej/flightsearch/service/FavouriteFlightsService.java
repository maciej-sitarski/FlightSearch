package com.sitarski.maciej.flightsearch.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dao.UserFavouriteFlightRepository;
import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.entity.SearchForm;
import com.sitarski.maciej.flightsearch.entity.userManage.UserFavouriteFlight;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavouriteFlightsService {

  private final ClientAttributionService clientAttributionService;
  private final SearchListService searchListService;
  private final StringFormatService stringFormatService;
  private final UserFavouriteFlightRepository userFavouriteFlightRepository;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  public FavouriteFlightsService(
      ClientAttributionService clientAttributionService,
      SearchListService searchListService,
      StringFormatService stringFormatService,
      UserFavouriteFlightRepository userFavouriteFlightRepository) {
    this.clientAttributionService = clientAttributionService;
    this.searchListService = searchListService;
    this.stringFormatService = stringFormatService;
    this.userFavouriteFlightRepository = userFavouriteFlightRepository;
  }

  public SingleCardOfFlightDto getSingleCardOfFavouriteFlightDto(
      UserFavouriteFlight userFavouriteFlight)
      throws InterruptedException, UnirestException, IOException {
    logger.info("Get single card of favourite flight dto");
    SearchForm searchForm = getSearchForm(userFavouriteFlight);
    String clientNumber = clientAttributionService.assignFavouriteClientNumber();
    Boolean correctFinding = searchListService.addItineraryToDataBase(clientNumber, searchForm);
    if(correctFinding) {
      return searchListService.getSingleCardOfFlight(userFavouriteFlight.getLegId());
    } else {
      return null;
    }
  }

  public SearchForm getSearchForm(UserFavouriteFlight userFavouriteFlight) {
    logger.info("Get search form");
    SearchForm searchForm = new SearchForm();
    searchForm.setOriginPlace(userFavouriteFlight.getOriginPlace());
    searchForm.setDestinationPlace(userFavouriteFlight.getDestinationPlace());
    searchForm.setOutboundDate(userFavouriteFlight.getOutboundDate());
    searchForm.setTransportClass(userFavouriteFlight.getTransportClass());
    searchForm.setNumberOfAdults(userFavouriteFlight.getNumberOfAdults());
    searchForm.setNumberOfChildren(userFavouriteFlight.getNumberOfChildren());
    searchForm.setNumberOfInfants(userFavouriteFlight.getNumberOfInfants());
    return searchForm;
  }

  public List<UserFavouriteFlight> getListOfFavouriteFlightsAfterCheckingStatus(
      List<UserFavouriteFlight> userFavouriteFlightList) {
    LocalDateTime now = LocalDateTime.now();
    List<UserFavouriteFlight> listFavouriteUsersFlightsToShow = userFavouriteFlightList.stream().filter(
        userFavouriteFlight -> stringFormatService
            .formatStringDateToDate(userFavouriteFlight.getOutboundDate()).isAfter(now)).collect(
        Collectors.toList());

    List<UserFavouriteFlight> listFavouriteUsersFlightsToDelete = userFavouriteFlightList.stream().filter(
        userFavouriteFlight -> stringFormatService
            .formatStringDateToDate(userFavouriteFlight.getOutboundDate()).isBefore(now)).collect(
        Collectors.toList());
    listFavouriteUsersFlightsToDelete.forEach(userFavouriteFlightRepository::delete);
    return listFavouriteUsersFlightsToShow;
  }
}
