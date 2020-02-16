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

    <div style="margin-top: 50px;margin-left: auto; margin-right: auto" >
      <h1>Sorry, there aren't any flights that match your <strong>filters</strong>.</h1>
    </div>
  </div>
  <div class="col-md-12" style="height: 400px"></div>
</div>
<#include "footer.ftlh">