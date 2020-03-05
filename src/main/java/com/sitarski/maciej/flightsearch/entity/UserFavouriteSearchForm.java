package com.sitarski.maciej.flightsearch.entity;

import lombok.Data;

@Data
public class UserFavouriteSearchForm {

  private String userId;
  private String legId;
  private SearchForm searchForm;

}
