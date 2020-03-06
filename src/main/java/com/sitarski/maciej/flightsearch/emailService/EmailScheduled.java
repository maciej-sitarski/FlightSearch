package com.sitarski.maciej.flightsearch.emailService;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dao.UserRepository;
import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.entity.userManage.User;
import com.sitarski.maciej.flightsearch.entity.userManage.UserFavouriteFlight;
import com.sitarski.maciej.flightsearch.service.FavouriteFlightsService;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduled {

  private final MailService mailService;
  private final FavouriteFlightsService favouriteFlightsService;
  private final UserRepository userRepository;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  public EmailScheduled(MailService mailService,
      FavouriteFlightsService favouriteFlightsService,
      UserRepository userRepository) {
    this.mailService = mailService;
    this.favouriteFlightsService = favouriteFlightsService;
    this.userRepository = userRepository;
  }

  @Scheduled(fixedRate = 86400000, initialDelay = 60000)
  public void sendEmails() {
    logger.info("Send email to all users");
    List<User> allUsers = userRepository.findAll();
    allUsers.forEach(this::sendEmailToSingleUser);
  }

  private void sendEmailToSingleUser(User user) {
    logger.info("Send email to single user");
    List<UserFavouriteFlight> userFavouriteFlightList = user.getUserFavouriteFlights();
    List<UserFavouriteFlight> userFavouriteFlightListAfterCheckingStatus = favouriteFlightsService
        .getListOfFavouriteFlightsAfterCheckingStatus(userFavouriteFlightList);
    if (userFavouriteFlightListAfterCheckingStatus.size() != 0) {
      List<SingleCardOfFlightDto> singleCardOfFlightDtoList = userFavouriteFlightListAfterCheckingStatus
          .stream()
          .map(userFavouriteFlight -> {
            try {
              return favouriteFlightsService.getSingleCardOfFavouriteFlightDto(userFavouriteFlight);
            } catch (InterruptedException | UnirestException | IOException e) {
              e.printStackTrace();
              return null;
            }
          })
          .collect(Collectors.toList());
      String content = prepareContent(singleCardOfFlightDtoList);
      mailService.sendEmail(user.getEmail(), content);
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private String prepareContent(List<SingleCardOfFlightDto> singleCardOfFlightDtoList) {
    logger.info("Prepare content");
    StringBuilder content = new StringBuilder();
    content.append(
        "Dear user, \nHere are your selected flights from flight search and their current price. Go to our site and manage your favourite flights. \n\n");
    singleCardOfFlightDtoList.forEach(singleCardOfFlightDto ->
        content.append(String
            .format(
                "From: %s,   To: %s,   Outbound date: %s,   Inbound time: %s,   Best price: %s zl \nLink to best price: %s \n\n",
                singleCardOfFlightDto.getOriginPlace(),
                singleCardOfFlightDto.getDestinationPlace(),
                singleCardOfFlightDto.getDepartureTime().toString().replaceAll("T", " "),
                singleCardOfFlightDto.getArrivalTime().toString().replaceAll("T", " "),
                singleCardOfFlightDto.getPrice().toString(),
                singleCardOfFlightDto.getUrl())));
    content.append("Regards, \nFlight Search MS");
    return content.toString();
  }
}
