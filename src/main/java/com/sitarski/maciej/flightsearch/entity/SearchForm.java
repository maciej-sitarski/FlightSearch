package com.sitarski.maciej.flightsearch.entity;

import java.time.LocalDate;
import java.util.Date;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class SearchForm {

  @NotBlank (message="Entering the origin place name is mandatory.")
  private String originPlace;

  @NotBlank(message="Entering the destination place name is mandatory.")
  private String destinationPlace;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @FutureOrPresent
  private LocalDate outboundDate;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @FutureOrPresent
  private LocalDate inboundDate;

  @NotBlank(message="Entering the transport class is mandatory.")
  private String transportClass;

  @Min(value = 1, message = "Number of adults should not be less than 1")
  @Max(value = 9, message = "Number of adults should not be more than 9")
  private Integer numberOfAdults;

  @Min(value = 0, message = "Number of children should not be less than 0")
  @Max(value = 9, message = "Number of children should not be more than 9")
  private Integer numberOfChildren;


  @Min(value = 0, message = "Number of infants should not be less than 0")
  @Max(value = 9, message = "Number of infants should not be more than 9")
  private Integer numberOfInfants;

}
