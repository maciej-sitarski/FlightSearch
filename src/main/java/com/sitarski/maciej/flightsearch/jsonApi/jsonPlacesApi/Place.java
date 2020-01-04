package com.sitarski.maciej.flightsearch.jsonApi.jsonPlacesApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {

  @JsonProperty("PlaceId")
  private String placeId;

  @JsonProperty("PlaceName")
  private String placeName;

  @JsonProperty("CountryId")
  private String countryId;

  @JsonProperty("RegionId")
  private String regionId;

  @JsonProperty("CityId")
  private String cityId;

  @JsonProperty("CountryName")
  private String countryName;

  public Place() {
  }

  public Place(String placeId, String placeName, String countryId, String regionId,
      String cityId, String countryName) {
    this.placeId = placeId;
    this.placeName = placeName;
    this.countryId = countryId;
    this.regionId = regionId;
    this.cityId = cityId;
    this.countryName = countryName;
  }

  public String getPlaceId() {
    return placeId;
  }

  public void setPlaceId(String placeId) {
    this.placeId = placeId;
  }

  public String getPlaceName() {
    return placeName;
  }

  public void setPlaceName(String placeName) {
    this.placeName = placeName;
  }

  public String getCountryId() {
    return countryId;
  }

  public void setCountryId(String countryId) {
    this.countryId = countryId;
  }

  public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public String getCityId() {
    return cityId;
  }

  public void setCityId(String cityId) {
    this.cityId = cityId;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }
}
