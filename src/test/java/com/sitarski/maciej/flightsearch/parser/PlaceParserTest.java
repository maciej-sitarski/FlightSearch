package com.sitarski.maciej.flightsearch.parser;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.jsonApi.jsonPlacesApi.PlaceList;
import java.io.IOException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PlaceParserTest {

  @Test
  void parsePlaces() throws IOException, UnirestException {

    //given
    PlaceParser placeParser = new PlaceParser();

    //when
    PlaceList placeList = placeParser.parsePlaces("Gdansk", "PLN");
    String placeName = placeList.getPlaces().get(0).getPlaceName();
    String countryName = placeList.getPlaces().get(0).getCountryName();

    //then
    Assert.assertEquals("Gdansk", placeName);
    Assert.assertEquals("Poland", countryName);

  }
}