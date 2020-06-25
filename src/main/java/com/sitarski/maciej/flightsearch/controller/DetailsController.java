package com.sitarski.maciej.flightsearch.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.dto.DetailCardDto;
import com.sitarski.maciej.flightsearch.dto.InformationDetailCardDto;
import com.sitarski.maciej.flightsearch.jsonApi.jasonAirportInfoApi.AirportApi;
import com.sitarski.maciej.flightsearch.service.AirportInfoService;
import com.sitarski.maciej.flightsearch.service.DetailsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailsController {

  private final DetailsService detailsService;
  private final AirportInfoService airportInfoService;

  @Autowired
  public DetailsController(
          DetailsService detailsService, AirportInfoService airportInfoService) {
    this.detailsService = detailsService;
    this.airportInfoService = airportInfoService;
  }

  @GetMapping("/flightDetails")
  public ModelAndView getFlightDetails(HttpServletRequest req) throws IOException, UnirestException {
    Map<String, Object> params = new HashMap<>();

    Long legId = Long.valueOf(req.getParameter("id"));

    InformationDetailCardDto informationDetailCardDto = detailsService
        .getInformationDetailCardDto(legId);
    List<DetailCardDto> detailCardDtoList = detailsService.getListOfDetailCardDto(legId);
    List<AirportApi> airportInfoList = new ArrayList<>();
    airportInfoList.add(airportInfoService.getAirportInfo(informationDetailCardDto.getOriginPlaceCode()));
    informationDetailCardDto.getStops().forEach(stop-> {
      try {
        airportInfoList.add(airportInfoService.getAirportInfo(stop.getCode()));
      } catch (IOException | UnirestException e) {
        e.printStackTrace();
      }
    });
    airportInfoList.add(airportInfoService.getAirportInfo(informationDetailCardDto.getDestinationPlaceCode()));
    params.put("airportList", airportInfoList);
//    AirportApi airportOriginInfo = airportInfoService.getAirportInfo(informationDetailCardDto.getOriginPlaceCode());
//    AirportApi airportDestinationInfo = airportInfoService.getAirportInfo(informationDetailCardDto.getDestinationPlaceCode());
//    params.put("originAirportInfo", airportOriginInfo);
//    params.put("destinationAirportInfo", airportDestinationInfo);
    params.put("informationCard", informationDetailCardDto);
    params.put("detailsList", detailCardDtoList);
    return new ModelAndView("details", params);
  }

  @GetMapping("/flightReturnDetails")
  public ModelAndView getReturnFlightDetails(HttpServletRequest req) {
    Map<String, Object> params = new HashMap<>();

    Long ouboundLegId = Long.valueOf(req.getParameter("outboundLegId"));
    Long inboundLegId = Long.valueOf(req.getParameter("inboundLegId"));

    InformationDetailCardDto informationFirstDetailCardDto = detailsService
        .getInformationDetailCardDto(ouboundLegId);
    InformationDetailCardDto informationSecondDetailCardDto = detailsService
        .getInformationDetailCardDto(inboundLegId);

    List<DetailCardDto> detailCardDtoList = detailsService.getListOfReturnFlightDetailCardDto(ouboundLegId, inboundLegId);

    params.put("informationFirstDetailCardDto", informationFirstDetailCardDto);
    params.put("informationSecondDetailCardDto", informationSecondDetailCardDto);
    params.put("detailsList", detailCardDtoList);

    return new ModelAndView("returnDetails", params);
  }
}
