<#include "navbar.ftlh">

<div class="container-fluid" style="background-color: #F5F5F5">
  <div class="row">
    <div class="col-md-6 offset-md-3 resultFlightHeading rounded-lg"
         style="text-align: center; height: 150px ">
      <h1 style="margin-top: 10px">
        Manage your favourite flights
      </h1>
      <a href="javascript:history.back()" class="btn" id="button" style="margin-top: 15px; width: 20%"> Return </a>
    </div>
  </div>

  <#if noResult?has_content>
  <div style="text-align: center">
    <h1 style="margin: 50px; color: #dd4b39">
        You don't have any flights in your favourite. Add flights to your favourite to manage them.
    </h1>
  </div>
    <div class="col-md-12" style="height: 600px"></div>
  <#else>

  <div class="row">
      <#list singleCardOfFlightList as singleCardOfFlight>
        <div class="col-md-6 offset-md-3  resultFlight rounded-lg" style="height: 310px; margin-bottom: 0 ">
          <div style="text-align: center">
            <h3 style="margin: 15px">
                ${singleCardOfFlight.originPlace} - ${singleCardOfFlight.destinationPlace}
            </h3>
            <h4>
              Date: <strong>${singleCardOfFlight.departureTime?substring(0,10)}</strong>
            </h4>
          </div>
          <input type="hidden"  id="principal" data-value="${principal.name}">
          <input type="hidden"  id="searchForm"
                 data-originPlace="${searchForm.originPlace}"
                 data-destinationPlace="${searchForm.destinationPlace}"
                 data-outboundDate="${searchForm.outboundDate}"
                 data-transportClass="${searchForm.transportClass}"
                 data-numberOfInfants="${searchForm.numberOfInfants}"
                 data-numberOfChildren="${searchForm.numberOfChildren}"
                 data-numberOfAdults="${searchForm.numberOfAdults}">

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
              <button onclick="deleteFavouriteFlight('${singleCardOfFlight.legItineraryId}')" id="buttonDeleteFavourite" >Delete from your flights</button>
            </div>
          </div>
        </div>
        <div class="w-100"></div>
      </#list>
  </div>
  <div class="col-md-12" style="height: 400px"></div>

  </#if>
</div>

<#include "footer.ftlh">