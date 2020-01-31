package com.sitarski.maciej.flightsearch.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class StringFormatServiceTest {

  @Test
  void formatStringPlaceToParse() {

    //given
    StringFormatService stringFormatService = new StringFormatService();

    //when
    String result = stringFormatService.formatStringPlaceToParse("GDANSK(GDN)");
    String result2 = stringFormatService.formatStringPlaceToParse("(WAW)WARSZAWA");
    String result3 = stringFormatService.formatStringPlaceToParse("KRA(KRK)KOW");

    //then
    Assert.assertEquals("GDN", result);
    Assert.assertEquals("WAW", result2);
    Assert.assertEquals("KRK", result3);
  }

  @Test
  void formatStringLocationHeaderToParse() {

    //given
    StringFormatService stringFormatService = new StringFormatService();

    //when
    String result = stringFormatService.formatStringLocationHeaderToParse("www.flightSearch.com/v1.0/currencies");
    String result2 = stringFormatService.formatStringLocationHeaderToParse("www.flightSearch.com/bookings");
    String result3 = stringFormatService.formatStringLocationHeaderToParse("www.flightSearch.com//v1.0//class");


    //then
    Assert.assertEquals("currencies", result);
    Assert.assertEquals("bookings", result2);
    Assert.assertEquals("class", result3);
  }
}