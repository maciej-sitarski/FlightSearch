package com.sitarski.maciej.flightsearch.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SearchForm {

  @NotBlank (message="Entering the origin place name is mandatory.")
  private String originPlace;

  @NotBlank(message="Entering the destination place name is mandatory.")
  private String destinationPlace;

  @NotBlank(message="Entering the outbound date is mandatory.")
  private String outboundDate;

  private String inboundDate;

  @NotBlank(message="Entering the transport class is mandatory.")
  private String transportClass;

  @NotNull(message="Entering the number of adults is mandatory.")
  @Min(1)
  @Max(9)
  private String numberOfAdults;

  @NotNull(message="Entering the number of children is mandatory.")
  @Min(0)
  @Max(9)
  private String numberOfChildren;

  @NotNull(message="Entering the number of infants is mandatory.")
  @Min(0)
  @Max(9)
  private String numberOfInfants;

}
