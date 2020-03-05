<#include "navbar.ftlh">
<div class="container-fluid" style="background-color: #F5F5F5">
  <div class="row">
    <div class="col-md-6 offset-md-3 resultFlightHeading rounded-lg"
         style="text-align: center;">
      <h1 style="margin-top: 10px">
        Search results for
      </h1>
      <h3 style="margin-top: 15px">
          ${singleCardOfFlightList[0].originPlace} - ${singleCardOfFlightList[0].destinationPlace}
        &nbsp;&nbsp;&nbsp;
        Date: ${informationCard.outboundDate}
      </h3>
      <h3 style="margin-top: 15px">
        Class: ${informationCard.cabinClass}
        &nbsp;&nbsp;&nbsp;
        Number of adults: ${informationCard.adults}
          <#if informationCard.children != 0>
            | Number of children: ${informationCard.children}
          </#if>
          <#if informationCard.infants != 0>
            | Number of infants: ${informationCard.infants}
          </#if>
      </h3>
      <a href="/home" class="btn" id="button" style="margin-top: 15px; width: 20%"> Return </a>
    </div>
  </div>


  <div class="row">
    <div class="col-md-3">
      <div class="col-md-11 offset-md-1 rounded-lg resultFlightFilters"
           style="text-align: center; font-family: sans-serif;">
        <form action="/oneWaySearchFilterList"
              method="get" id="form">
          <input type="hidden"  name="clientNumber" value="${singleCardOfFlightList[0].clientNumber}">
          <#if searchForm?has_content>
                <input type="hidden"  id="searchForm"
                 data-originPlace="${searchForm.originPlace}"
                 data-destinationPlace="${searchForm.destinationPlace}"
                 data-outboundDate="${searchForm.outboundDate}"
                 data-transportClass="${searchForm.transportClass}"
                 data-numberOfInfants="${searchForm.numberOfInfants}"
                 data-numberOfChildren="${searchForm.numberOfChildren}"
                 data-numberOfAdults="${searchForm.numberOfAdults}">
          </#if>

            <#if principal?has_content>
              <input type="hidden"  id="principal" data-value="${principal.name}">
            </#if>
          <h1 style="margin-top: 20px; padding-top: 20px">
            <strong>Filters</strong>
          </h1>
          <h3 style="margin-top: 20px">
            Number of stops:
          </h3>
          <div class="form-check form-check-inline" style="margin-bottom: 30px; ">
            <input type="checkbox" class="form-check-input" id="direct"
                   onchange="$('#form').submit();"
                    <#if filterForm.direct?has_content>
                      checked
                    </#if>
                   name="direct" style="margin-right: 10px">
            <label class="form-check-label" for="direct" style="color: black; margin-right: 35px">Direct</label>
            <input type="checkbox" class="form-check-input" id="1stop"
                   onchange="$('#form').submit();"
                    <#if filterForm.oneStop?has_content>
                      checked
                    </#if>
                   name="oneStop"
                   style="margin-right: 10px">
            <label class="form-check-label" for="1stop" style="color: black; margin-right: 35px ">1
              stop</label>
            <input type="checkbox" class="form-check-input" id="2stops"
                   onchange="$('#form').submit();"
                    <#if filterForm.moreStops?has_content>
                      checked
                    </#if>
                   name="moreStops"
                   style="margin-right: 10px; ">
            <label class="form-check-label" for="2stops" style="color: black;">2+ stops</label>
          </div>
          <div class="form-check form-check-inline" style="color: black; ">
            <input class="form-check-input" type="checkbox" onclick="dynInputOutbound(this);"
                    <#if filterForm.outboundTimeFrom?has_content>
                      checked
                    </#if>
                   name="outboundCheckbox" style="margin-right: 10px;  transform: scale(1.2)">
            <label style="font-size: 28px; color: black; margin-right: 15px"
                   class="form-check-label"
                   for="outboundCheckbox">Outbound
              time</label>
          </div>
          <div class="form-check form-check-inline" style="color: black; margin-bottom: 30px">
              <#if filterForm.outboundTimeFrom?has_content>
                <label class="form-check-label" style="color: black; margin-top: 12px; "
                       id="outboundTime">
                  <label id="outboundCheckbox">
                    <label style="font-size: 20px;">From:
                      <input type="time" required
                             id="outboundCheckbox"
                             name="outboundTimeFrom" step="900"
                             style="font-size: 22px; width: 100px; height: 40px; "
                             value=${filterForm.outboundTimeFrom}></label>
                    <label style="font-size: 20px;">To:
                      <input type="time" required
                             id="outboundCheckbox"
                             name="outboundTimeTo" step="900"
                             style="font-size: 22px; width: 100px; height: 40px; "
                             value=${filterForm.outboundTimeTo}></label>
                  </label>
                </label>
              <#else>
                <label class="form-check-label" style="color: black; margin-top: 12px"
                       id="outboundTime"></label>
              </#if>
          </div>
          <div></div>
          <div class="form-check form-check-inline" style="color: black; ">
            <input class="form-check-input" type="checkbox" onclick="dynInputDuration(this);"
                    <#if filterForm.duration?has_content>
                      checked
                    </#if>
                   name="durationCheckbox" style="margin-right: 10px;  transform: scale(1.2)">
            <label class="form-check-label" for="durationCheckbox"
                   style="font-size: 28px; color: black; margin-right: 3px">
              Duration <small>(number of hours)</small>
            </label>
          </div>
          <div class="form-check form-check-inline" style="color: black; margin-bottom: 30px">
              <#if filterForm.duration?has_content>
                <label class="form-check-label" style=" margin-top: 12px" id="durationTime">
                  <input type="number" required id="durationCheckbox" name="duration" min="1"
                         style="font-size: 22px; width: 50px; height: 40px"
                         value=${filterForm.duration}></input>
                  <label for="duration" id="durationCheckbox"></label>
                </label>
              <#else>
                <label class="form-check-label" style=" margin-top: 12px" id="durationTime"></label>
              </#if>
          </div>
          <h3>
            Sort by:
          </h3>
          <div class="form-check form-check-inline" style="margin-bottom: 20px">
              <#if filterForm.sortOrder?has_content>
                <select  name="sortOrder" style="width:300px;" class="select-css"
                         onchange="$('#form').submit();">
                  <option
                          <#if filterForm.sortOrder == "sortDepartureTime">
                            selected
                          </#if>
                      value="sortDepartureTime">Outbound: Departure time
                  </option>
                  <option
                          <#if filterForm.sortOrder == "sortCheapest">
                            selected
                          </#if>
                      value="sortCheapest">Cheapest first
                  </option>
                  <option
                          <#if filterForm.sortOrder == "sortFastest">
                            selected
                          </#if>
                      value="sortFastest">Fastest first
                  </option>
                </select>
              <#else>
                <select style=" width: 300px;" name="sortOrder" class="select-css"
                        onchange="$('#form').submit();">
                  <option selected value="sortDepartureTime">Outbound: Departure time</option>
                  <option value="sortCheapest">Cheapest first</option>
                  <option value="sortFastest">Fastest first</option>
                </select>
              </#if>
          </div>
          <div></div>
          <button type="submit"
                  id="button">
            Filter
          </button>
        </form>
      </div>
    </div>
    <div class="col-md-6">
      <div class="row">
          <#list singleCardOfFlightList as singleCardOfFlight>

            <div class="col-md-12  resultFlight rounded-lg">
              <div class="row" style="height: 200px;">
                <div class="col-md-2">
                    <#if singleCardOfFlight.carrierName?size == 1>
                      <div class="logo" style="margin-top: 45%">
                        <img alt="" src="${singleCardOfFlight.carrierImageUrl[0]}">
                      </div>
                    <#elseif singleCardOfFlight.carrierName?size == 2>
                      <div class="logo" style="margin-top: 25%">
                        <img alt="" src="${singleCardOfFlight.carrierImageUrl[0]}"
                             style="margin-bottom: 10%">
                        <img alt="" src="${singleCardOfFlight.carrierImageUrl[1]}">
                      </div>
                    <#else>
                      <div class="logoInscription " style="margin-top: 55%">
                          <#list singleCardOfFlight.carrierName as carrierName>
                              <#if !(carrierName_has_next)>
                                <h5 class="d-inline"
                                    style="font-family: 'Tonto', serif;">
                                    ${carrierName}
                                </h5>
                              <#else>
                                <h5 class="d-inline"
                                    style="font-family: 'Tonto', serif;">
                                    ${carrierName} +
                                </h5>
                              </#if>
                          </#list>
                      </div>
                    </#if>
                </div>
                <div class="col-md-2 text-center">
                  <h1 style="margin-top: 40%; font-family: 'Tonto', serif;">
                      ${singleCardOfFlight.departureTime?substring(11,16)}
                  </h1>
                  <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                      ${singleCardOfFlight.originPlaceCode}
                  </h5>
                </div>
                <div class="col-md-3 text-center">
                  <h4 style="margin-top: 20%; font-family: 'Tonto', serif;">
                      ${(singleCardOfFlight.duration/60)?int} h ${singleCardOfFlight.duration%60}
                    min
                  </h4>
                  <img alt="" src="img/arrow.png" class="img-fluid">
                    <#if singleCardOfFlight.stops?size == 0>
                      <h4 style="font-family: 'Tonto', serif; color: green">
                        Direct
                      </h4>
                    <#elseif singleCardOfFlight.stops?size == 1>
                      <h4 style="font-family: 'Tonto', serif; color: red">
                        1 stop
                      </h4>
                    <#else>
                      <h4 style="font-family: 'Tonto', serif; color: red">
                          ${singleCardOfFlight.stops?size} stops
                      </h4>
                    </#if>
                </div>
                <div class="col-md-2 text-center">
                  <h1 style="margin-top: 40%; font-family: 'Tonto', serif;">
                      ${singleCardOfFlight.arrivalTime?substring(11,16)}
                  </h1>
                  <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                      ${singleCardOfFlight.destinationPlaceCode}
                  </h5>
                </div>
                <div class="col-md-3 text-center">
                  <p style="margin-top: 15%; margin-bottom: 0; color: dimgrey">
                    deals from</p>
                  <h3><strong>
                          ${singleCardOfFlight.price}
                    </strong> zł
                  </h3>
                  <a href="/flightDetails?id=${singleCardOfFlight.legId}" class="btn btn-success btn-lg" style="font-size: 25px">
                    Select </a>
                  <#if principal?has_content>
                          <#if favouriteFlights?seq_contains(singleCardOfFlight.legItineraryId)>
                              <button onclick="deleteFavouriteFlight('${singleCardOfFlight.legItineraryId}')" id="buttonDeleteFavourite" >Delete from your flights</button>
                          <#else>
                              <button onclick="saveFavouriteFlight('${singleCardOfFlight.legItineraryId}')" id="buttonSaveFavourite" >Add to your flights</button>
                          </#if>
                  </#if>
                </div>
              </div>
            </div>
            <div class="w-100"></div>
          </#list>
      </div>
    </div>
  </div>
</div>
<#include "footer.ftlh">