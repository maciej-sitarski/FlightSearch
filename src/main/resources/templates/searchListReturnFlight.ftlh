<#include "navbar.ftlh">
<div class="container-fluid" style="background-color: #F5F5F5">
  <div class="row">
    <div class="col-md-6 offset-md-3 resultFlightHeading rounded-lg"
         style="text-align: center;">
      <h1 style="margin-top: 10px">
        Search results for
      </h1>
      <h3 style="margin-top: 10px">
          ${doubleCardOfFlightList[0].outboundLeg.originPlace}
        - ${doubleCardOfFlightList[0].outboundLeg.destinationPlace}
      </h3>
      <h4>
        Outbound date: ${informationCard.outboundDate} | Inbound
        date: ${informationCard.inboundDate}
      </h4>
      <h4 style="margin-top: 10px">
        Class: ${informationCard.cabinClass}
        &nbsp;&nbsp;&nbsp;
        Number of adults: ${informationCard.adults}
          <#if informationCard.children != 0>
            | Number of children: ${informationCard.children}
          </#if>
          <#if informationCard.infants != 0>
            | Number of infants: ${informationCard.infants}
          </#if>
      </h4>
      <a href="/home" class="btn" id="button"  style=" width: 20%"> Return </a>
    </div>
  </div>

  <div class="row">
    <div class="col-md-3">
      <div class="col-md-11 offset-md-1 rounded-lg resultFlightFilters"
           style="text-align: center; font-family: sans-serif;">
        <form action="/returnSearchFilterList" method="get" id="form">
          <input type="hidden" name="clientNumber"
                 value=${doubleCardOfFlightList[0].outboundLeg.clientNumber}>
          <h1 style="margin-top: 20px; padding-top: 20px">
            Filters
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
                   style="margin-right: 10px">
            <label class="form-check-label" for="2stops" style="color: black">2+ stops</label>
          </div>
          <div class="form-check form-check-inline" style="color: black">
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
          <div class="form-check form-check-inline" style="color: black">
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
                <select style=" width: 300px;" name="sortOrder" class="select-css"
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
          <#list doubleCardOfFlightList as doubleCardOfFlight>
            <div class="col-md-12  resultFlightReturn rounded-lg">
              <div class="row" style="height: 200px;">
                <div class="col-md-2">
                    <#if doubleCardOfFlight.outboundLeg.carrierName?size == 1>
                      <div class="logo" style="margin-top: 45%">
                        <img alt="" src="${doubleCardOfFlight.outboundLeg.carrierImageUrl[0]}">
                      </div>
                    <#elseif doubleCardOfFlight.outboundLeg.carrierName?size == 2>
                      <div class="logo" style="margin-top: 25%">
                        <img alt="" src="${doubleCardOfFlight.outboundLeg.carrierImageUrl[0]}"
                             style="margin-bottom: 10%">
                        <img alt="" src="${doubleCardOfFlight.outboundLeg.carrierImageUrl[1]}">
                      </div>
                    <#else>
                      <div class="logoInscription " style="margin-top: 55%">
                          <#list doubleCardOfFlight.outboundLeg.carrierName as carrierName>
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
                      ${doubleCardOfFlight.outboundLeg.departureTime?substring(11,16)}
                  </h1>
                  <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                      ${doubleCardOfFlight.outboundLeg.originPlaceCode}
                  </h5>
                </div>
                <div class="col-md-3 text-center">
                  <h4 style="margin-top: 20%; font-family: 'Tonto', serif;">
                      ${(doubleCardOfFlight.outboundLeg.duration/60)?int}
                    h ${doubleCardOfFlight.outboundLeg.duration%60} min
                  </h4>
                  <img alt="" src="img/arrow.png" class="img-fluid">
                    <#if doubleCardOfFlight.outboundLeg.stops?size == 0>
                      <h4 style="font-family: 'Tonto', serif; color: green">
                        Direct
                      </h4>
                    <#elseif doubleCardOfFlight.outboundLeg.stops?size == 1>
                      <h4 style="font-family: 'Tonto', serif; color: red">
                        1 stop
                      </h4>
                    <#else>
                      <h4 style="font-family: 'Tonto', serif; color: red">
                          ${doubleCardOfFlight.outboundLeg.stops?size} stops
                      </h4>
                    </#if>
                </div>
                <div class="col-md-2 text-center">
                  <h1 style="margin-top: 40%; font-family: 'Tonto', serif;">
                      ${doubleCardOfFlight.outboundLeg.arrivalTime?substring(11,16)}
                  </h1>
                  <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                      ${doubleCardOfFlight.outboundLeg.destinationPlaceCode}
                  </h5>
                </div>
                <div class="col-md-3 text-center">
                  <p style="margin-top: 60%; margin-bottom: 0; color: dimgrey">
                    deals from</p>
                  <h3><strong>
                          ${doubleCardOfFlight.price}
                    </strong> zł
                  </h3>
                </div>
              </div>
            </div>
            <div class="w-100"></div>
            <div class="col-md-12 resultFlightReturn2 rounded-lg">
              <div class="row" style="height: 200px;">
                <div class="col-md-2">
                    <#if doubleCardOfFlight.inboundLeg.carrierName?size == 1>
                      <div class="logo" style="margin-top: 45%">
                        <img alt="" src="${doubleCardOfFlight.inboundLeg.carrierImageUrl[0]}">
                      </div>
                    <#elseif doubleCardOfFlight.inboundLeg.carrierName?size == 2>
                      <div class="logo" style="margin-top: 25%">
                        <img alt="" src="${doubleCardOfFlight.inboundLeg.carrierImageUrl[0]}"
                             style="margin-bottom: 10%">
                        <img alt="" src="${doubleCardOfFlight.inboundLeg.carrierImageUrl[1]}">
                      </div>
                    <#else>
                      <div class="logoInscription " style="margin-top: 55%">
                          <#list doubleCardOfFlight.inboundLeg.carrierName as carrierName>
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
                      ${doubleCardOfFlight.inboundLeg.departureTime?substring(11,16)}
                  </h1>
                  <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                      ${doubleCardOfFlight.inboundLeg.originPlaceCode}
                  </h5>
                </div>
                <div class="col-md-3 text-center">
                  <h4 style="margin-top: 20%; font-family: 'Tonto', serif;">
                      ${(doubleCardOfFlight.inboundLeg.duration/60)?int}
                    h ${doubleCardOfFlight.inboundLeg.duration%60} min
                  </h4>
                  <img alt="" src="img/arrow.png" class="img-fluid">
                    <#if doubleCardOfFlight.inboundLeg.stops?size == 0>
                      <h4 style="font-family: 'Tonto', serif; color: green">
                        Direct
                      </h4>
                    <#elseif doubleCardOfFlight.inboundLeg.stops?size == 1>
                      <h4 style="font-family: 'Tonto', serif; color: red">
                        1 stop
                      </h4>
                    <#else>
                      <h4 style="font-family: 'Tonto', serif; color: red">
                          ${doubleCardOfFlight.inboundLeg.stops?size} stops
                      </h4>
                    </#if>
                </div>
                <div class="col-md-2 text-center">
                  <h1 style="margin-top: 40%; font-family: 'Tonto', serif;">
                      ${doubleCardOfFlight.inboundLeg.arrivalTime?substring(11,16)}
                  </h1>
                  <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                      ${doubleCardOfFlight.inboundLeg.destinationPlaceCode}
                  </h5>
                </div>
                <div class="col-md-3 text-center">
                  <a href="/flightReturnDetails?outboundLegId=${doubleCardOfFlight.outboundLegId}&inboundLegId=${doubleCardOfFlight.inboundLegId}" class="btn btn-success btn-lg" style="font-size: 25px">
                    Select </a>
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