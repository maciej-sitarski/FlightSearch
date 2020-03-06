package com.sitarski.maciej.flightsearch.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StringFormatService {

  public String formatStringPlaceToParse(String place){
    return StringUtils.substringBetween(place, "(", ")");
  }

  public String formatStringLocationHeaderToParse(String location){
    return StringUtils.substringAfterLast(location, "/");
  }

  public LocalDateTime formatStringDateToDate(String stringDate)  {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String stringFormatDate = stringDate.replaceAll("T", " ");
    return LocalDateTime.parse(stringFormatDate, formatter);
  }

  public String formatStringPlace(String place){
    return StringUtils.substringBefore(place, "-");
  }

  public LocalDateTime formatStringDateToLocalDate(String stringDate)  {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String stringFormatDate = stringDate.replaceAll("T", " ");
    return LocalDateTime.parse(stringFormatDate, formatter);
  }
}
