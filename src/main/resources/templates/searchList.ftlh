<#include "navbar.ftlh">
<div class="container-fluid">
  <div class="row">
    <div class="col-md-4 offset-md-2 resultFlightHeading rounded-lg"
         style="text-align: center; font-family: 'Tonto', serif;">
      <h1 style="margin-top: 10px">
        Search results for
      </h1>
      <h2 style="margin-top: 20px">
          ${singleCardOfFlightList[0].originPlace} - ${singleCardOfFlightList[0].destinationPlace}
      </h2>
      <h2 style="margin-top: 20px">
        Date: ${informationCard.outboundDate}
      </h2>
      <h2 style="margin-top: 20px">
        Class: ${informationCard.cabinClass}
      </h2>
      <h4 style="margin-top: 20px">
        Number of adults: ${informationCard.adults}
          <#if informationCard.children != 0>
            | Number of children: ${informationCard.children}
          </#if>
          <#if informationCard.infants != 0>
            | Number of infants: ${informationCard.infants}
          </#if>
      </h4>
      <a href="/home" class="btn btn-light btn-lg" style="margin-top: 15px"> Return </a>
    </div>
    <div class="col-md-4 rounded-lg resultFlightFilters"
         style="text-align: center; font-family: 'Tonto', serif;">
      <form action="/oneWaySearchFilterList"
            method="get">
        <input type="hidden" name="clientNumber" value=${singleCardOfFlightList[0].clientNumber}>
        <h1 style="margin-top: 10px">
          Filters
        </h1>
        <div class="form-check form-check-inline" style="color: black">
          <h2 style="margin-right: 40px">
            Stops:
          </h2>
          <input type="checkbox" class="form-check-input" id="direct"
                  <#if filterForm.direct?has_content>
                    checked
                  </#if>
                 name="direct" style="margin-right: 10px">
          <label class="form-check-label" for="direct" style="color: black; margin-right: 25px">Direct</label>
        </div>
        <div class="form-check form-check-inline" style="color: black">
          <input type="checkbox" class="form-check-input" id="1stop"
                  <#if filterForm.oneStop?has_content>
                    checked
                  </#if>
                 name="oneStop"
                 style="margin-right: 10px">
          <label class="form-check-label" for="1stop" style="color: black; margin-right: 25px ">1
            stop</label>
        </div>
        <div class="form-check form-check-inline" style="color: black">
          <input type="checkbox" class="form-check-input" id="2stops"
                  <#if filterForm.moreStops?has_content>
                    checked
                  </#if>
                 name="moreStops"
                 style="margin-right: 10px">
          <label class="form-check-label" for="2stops" style="color: black">2+ stops</label>
        </div>
        <div></div>
        <div class="form-check form-check-inline" style="color: black">
          <input class="form-check-input" type="checkbox" onclick="dynInputOutbound(this);"
                  <#if filterForm.outboundTimeFrom?has_content>
                    checked
                  </#if>
                 name="outboundCheckbox" style="margin-right: 10px;  transform: scale(1.2)">
          <label style="font-size: 30px; color: black; margin-right: 15px" class="form-check-label"
                 for="outboundCheckbox">Outbound
            time</label>
          <label class="form-check-label" style="color: black; margin-top: 12px"
                 id="outboundTime"></label>
        </div>
        <div></div>
        <div class="form-check form-check-inline" style="color: black">
          <input class="form-check-input" type="checkbox" onclick="dynInputDuration(this);"
                  <#if filterForm.duration?has_content>
                    checked
                  </#if>
                 name="durationCheckbox" style="margin-right: 10px;  transform: scale(1.2)">
          <label class="form-check-label" for="durationCheckbox"
                 style="font-size: 30px; color: black; margin-right: 15px">
            Duration (max number of hours)
          </label>
          <label class="form-check-label" style=" margin-top: 12px" id="durationTime"></label>
        </div>
        <div></div>
        <div class="form-check form-check-inline" style="margin-top: 10px">
          <label style="color: black; margin-right: 10px; font-size: 30px">Sort by</label>

            <#if filterForm.sortOrder?has_content>
              <select style="font-size: 25px; width: 400px;" name="sortOrder">
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
              <select style="font-size: 25px; width: 400px;" name="sortOrder">
                <option selected value="sortDepartureTime">Outbound: Departure time</option>
                <option  value="sortCheapest">Cheapest first</option>
                <option value="sortFastest">Fastest first</option>
              </select>
            </#if>
        </div>
        <div></div>
        <button class="btn btn-primary" type="submit"
                style="margin-top: 20px; width: 30%; font-size: 25px">
          Filter
        </button>
      </form>

    </div>
  </div>
  <div class="row">
      <#list singleCardOfFlightList as singleCardOfFlight>
        <div class="col-md-6 offset-md-3 resultFlight rounded-lg">
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
                  ${(singleCardOfFlight.duration/60)?int} h ${singleCardOfFlight.duration%60} min
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
              <a href="#" class="btn btn-success btn-lg" style="font-size: 25px">
                Select </a>
            </div>
          </div>
        </div>
        <div class="w-100"></div>
      </#list>
  </div>
</div>
<#include "footer.ftlh">