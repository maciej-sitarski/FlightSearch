package com.sitarski.maciej.flightsearch.controller;

import com.sitarski.maciej.flightsearch.dto.DetailCardDto;
import com.sitarski.maciej.flightsearch.dto.InformationDetailCardDto;
import com.sitarski.maciej.flightsearch.service.DetailsService;
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

  @Autowired
  public DetailsController(
      DetailsService detailsService) {
    this.detailsService = detailsService;
  }

  @GetMapping("/flightDetails")
  public ModelAndView getFlightDetails(HttpServletRequest req) {
    Map<String, Object> params = new HashMap<>();

    Long legId = Long.valueOf(req.getParameter("id"));

    InformationDetailCardDto informationDetailCardDto = detailsService
        .getInformationDetailCardDto(legId);
    List<DetailCardDto> detailCardDtoList = detailsService.getListOfDetailCardDto(legId);

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
