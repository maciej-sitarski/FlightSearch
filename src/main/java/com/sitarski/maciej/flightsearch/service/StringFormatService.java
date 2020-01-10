package com.sitarski.maciej.flightsearch.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StringFormatService {

  public String formatStringPlaceToParse(String place){
    return StringUtils.substringBetween(place, "(", ")");
  }

  public String formatStringLocationHeaderToParse(String location){
    return StringUtils.substringAfterLast(location, "/");
  }
}
