package com.sitarski.maciej.flightsearch.service;

import com.sitarski.maciej.flightsearch.dto.DoubleCardOfFlightDto;
import com.sitarski.maciej.flightsearch.entity.FilterForm;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FilterMultipleService {

  public List<DoubleCardOfFlightDto> filtrResult(List<DoubleCardOfFlightDto> unfiltredList,
      FilterForm filterForm) {

    List<DoubleCardOfFlightDto> resultList = unfiltredList;
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

  public List<DoubleCardOfFlightDto> sortedByOutboundDate(
      List<DoubleCardOfFlightDto> doubleCardOfFlightDtoList) {
    return doubleCardOfFlightDtoList.stream()
        .sorted(Comparator.comparing(doubleCardOfFlightDto -> doubleCardOfFlightDto.getOutboundLeg().getDepartureTime())).collect(
            Collectors.toList());
  }

  private List<DoubleCardOfFlightDto> sortedByPrice(
      List<DoubleCardOfFlightDto> doubleCardOfFlightDtoList) {
    return doubleCardOfFlightDtoList.stream()
        .sorted(Comparator.comparing(DoubleCardOfFlightDto::getPrice)).collect(
            Collectors.toList());
  }

  private List<DoubleCardOfFlightDto> sortedByTime(
      List<DoubleCardOfFlightDto> doubleCardOfFlightDtoList) {
    return doubleCardOfFlightDtoList.stream()
        .sorted(Comparator.comparing(doubleCardOfFlightDto -> doubleCardOfFlightDto.getOutboundLeg().getDuration()+doubleCardOfFlightDto.getInboundLeg().getDuration())).collect(
            Collectors.toList());
  }

  private List<DoubleCardOfFlightDto> filterByNumberOfStops(
      List<DoubleCardOfFlightDto> doubleCardOfFlightDtoList, FilterForm filterForm) {
    String direct = filterForm.getDirect();
    String oneStop = filterForm.getOneStop();
    String moreStops = filterForm.getMoreStops();
    List<DoubleCardOfFlightDto> resultList = doubleCardOfFlightDtoList;
    if (direct == null) {
      resultList = resultList.stream()
          .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getOutboundLeg().getStops().size() != 0)
          .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getInboundLeg().getStops().size() != 0)
          .collect(Collectors.toList());
    }
    if (oneStop == null) {
      resultList = resultList.stream()
          .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getOutboundLeg().getStops().size() != 1)
          .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getInboundLeg().getStops().size() != 1)
          .collect(Collectors.toList());
    }
    if (moreStops == null) {
      resultList = resultList.stream()
          .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getOutboundLeg().getStops().size() != 2)
          .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getInboundLeg().getStops().size() != 2)
          .collect(Collectors.toList());

      resultList = resultList.stream()
          .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getOutboundLeg().getStops().size() != 3)
          .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getInboundLeg().getStops().size() != 3)
          .collect(Collectors.toList());
    }
    return resultList;
  }

  private List<DoubleCardOfFlightDto> filterByOutboundTime(
      List<DoubleCardOfFlightDto> doubleCardOfFlightDtoList, FilterForm filterForm) {
    String outboundTimeStringFrom = filterForm.getOutboundTimeFrom();
    String outboundTimeStringTo = filterForm.getOutboundTimeTo();

    Integer outboundHourFrom = Integer.valueOf(outboundTimeStringFrom.substring(0,2));
    Integer outboundMinutesFrom = Integer.valueOf(outboundTimeStringFrom.substring(3,5));
    Integer outboundHourTo = Integer.valueOf(outboundTimeStringTo.substring(0,2));

    List<DoubleCardOfFlightDto> resultList = doubleCardOfFlightDtoList;

    resultList = resultList.stream()
        .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getOutboundLeg().getDepartureTime().getHour()
            >= outboundHourFrom)
        .collect(Collectors.toList());

    List<DoubleCardOfFlightDto> cardsToRemove = resultList.stream().filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getOutboundLeg().getDepartureTime().getHour() == outboundHourFrom)
        .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getOutboundLeg().getDepartureTime().getMinute()
            >= outboundMinutesFrom)
        .collect(Collectors.toList());
    resultList.removeAll(cardsToRemove);

    resultList = resultList.stream()
        .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getOutboundLeg().getDepartureTime().getHour()
            < outboundHourTo)
        .collect(Collectors.toList());

    return resultList;
  }

  private List<DoubleCardOfFlightDto> filterByDuration(
      List<DoubleCardOfFlightDto> doubleCardOfFlightDtoList, FilterForm filterForm) {

    Integer duration = Integer.valueOf(filterForm.getDuration());
    List<DoubleCardOfFlightDto> resultList = doubleCardOfFlightDtoList;

    resultList = resultList.stream()
        .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getOutboundLeg().getDuration()<=duration*60)
        .filter(doubleCardOfFlightDto -> doubleCardOfFlightDto.getInboundLeg().getDuration()<=duration*60)
        .collect(Collectors.toList());

    return resultList;
  }

}
