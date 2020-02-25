package com.sitarski.maciej.flightsearch.service;

import com.sitarski.maciej.flightsearch.dto.SingleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.entity.FilterForm;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FilterOneWayService {

  public List<SingleCardOfFlightDto> filtrResult(List<SingleCardOfFlightDto> unfiltredList,
      FilterForm filterForm) {

    List<SingleCardOfFlightDto> resultList = unfiltredList;
    String outboundTimeFrom = filterForm.getOutboundTimeFrom();
    String duration = filterForm.getDuration();
    String sortOrder = filterForm.getSortOrder();


    resultList = filterByNumberOfStops(resultList, filterForm);
    if(outboundTimeFrom != null){
      resultList = filterByOutboundTime(resultList, filterForm);
    }
    if(duration != null){
      resultList = filterByDuration(resultList, filterForm);
    }

    if(sortOrder.equals("sortDepartureTime")){
      resultList = sortedByOutboundDate(resultList);
    } else if(sortOrder.equals("sortCheapest")){
      resultList = sortedByPrice(resultList);
    } else {
      resultList = sortedByTime(resultList);
    }
    return resultList;
  }

  public List<SingleCardOfFlightDto> sortedByOutboundDate(
      List<SingleCardOfFlightDto> singleCardOfFlightDtoList) {
    return singleCardOfFlightDtoList.stream()
        .sorted(Comparator.comparing(SingleCardOfFlightDto::getDepartureTime)).collect(
            Collectors.toList());
  }

  private List<SingleCardOfFlightDto> sortedByPrice(
      List<SingleCardOfFlightDto> singleCardOfFlightDtoList) {
    return singleCardOfFlightDtoList.stream()
        .sorted(Comparator.comparing(SingleCardOfFlightDto::getPrice)).collect(
            Collectors.toList());
  }

  private List<SingleCardOfFlightDto> sortedByTime(
      List<SingleCardOfFlightDto> singleCardOfFlightDtoList) {
    return singleCardOfFlightDtoList.stream()
        .sorted(Comparator.comparing(SingleCardOfFlightDto::getDuration)).collect(
            Collectors.toList());
  }

  private List<SingleCardOfFlightDto> filterByNumberOfStops(
      List<SingleCardOfFlightDto> singleCardOfFlightDtoList, FilterForm filterForm) {
    String direct = filterForm.getDirect();
    String oneStop = filterForm.getOneStop();
    String moreStops = filterForm.getMoreStops();
    List<SingleCardOfFlightDto> resultList = singleCardOfFlightDtoList;
    if (direct == null) {
      resultList = resultList.stream()
          .filter(singleCardOfFlightDto -> singleCardOfFlightDto.getStops().size() != 0).collect(
              Collectors.toList());
    }
    if (oneStop == null) {
      resultList = resultList.stream()
          .filter(singleCardOfFlightDto -> singleCardOfFlightDto.getStops().size() != 1).collect(
              Collectors.toList());
    }
    if (moreStops == null) {
      resultList = resultList.stream()
          .filter(singleCardOfFlightDto -> singleCardOfFlightDto.getStops().size() != 2).collect(
              Collectors.toList());
      resultList = resultList.stream()
          .filter(singleCardOfFlightDto -> singleCardOfFlightDto.getStops().size() != 3).collect(
              Collectors.toList());
      resultList = resultList.stream()
          .filter(singleCardOfFlightDto -> singleCardOfFlightDto.getStops().size() != 4).collect(
              Collectors.toList());
    }
    return resultList;
  }

  private List<SingleCardOfFlightDto> filterByOutboundTime(
      List<SingleCardOfFlightDto> singleCardOfFlightDtoList, FilterForm filterForm) {
    String outboundTimeStringFrom = filterForm.getOutboundTimeFrom();
    String outboundTimeStringTo = filterForm.getOutboundTimeTo();

    Integer outboundHourFrom = Integer.valueOf(outboundTimeStringFrom.substring(0,2));
    Integer outboundMinutesFrom = Integer.valueOf(outboundTimeStringFrom.substring(3,5));
    Integer outboundHourTo = Integer.valueOf(outboundTimeStringTo.substring(0,2));

    List<SingleCardOfFlightDto> resultList = singleCardOfFlightDtoList;

    resultList = resultList.stream()
        .filter(singleCardOfFlightDto -> singleCardOfFlightDto.getDepartureTime().getHour()
            >= outboundHourFrom)
        .collect(Collectors.toList());

    List<SingleCardOfFlightDto> cardsToRemove = resultList.stream().filter(singleCardOfFlightDto -> singleCardOfFlightDto.getDepartureTime().getHour() == outboundHourFrom)
        .filter(singleCardOfFlightDto -> singleCardOfFlightDto.getDepartureTime().getMinute()
            >= outboundMinutesFrom)
        .collect(Collectors.toList());
    resultList.removeAll(cardsToRemove);


    resultList = resultList.stream()
        .filter(singleCardOfFlightDto -> singleCardOfFlightDto.getDepartureTime().getHour()
            < outboundHourTo)
        .collect(Collectors.toList());

    return resultList;
  }

  private List<SingleCardOfFlightDto> filterByDuration(
      List<SingleCardOfFlightDto> singleCardOfFlightDtoList, FilterForm filterForm) {

    Integer duration = Integer.valueOf(filterForm.getDuration());
    List<SingleCardOfFlightDto> resultList = singleCardOfFlightDtoList;

    resultList = resultList.stream()
        .filter(singleCardOfFlightDto -> singleCardOfFlightDto.getDuration()<=duration*60)
        .collect(Collectors.toList());

    return resultList;
  }
}
