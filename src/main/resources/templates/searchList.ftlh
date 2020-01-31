<#include "navbar.ftlh">
<div class="container-fluid">
  <div class="row">
    <div class="col-md-6 offset-md-3 resultFlightHeading rounded-lg"
         style="text-align: center; font-family: 'Tonto', serif;">
      <h1 style="margin-top: 20px">
        Search results for
      </h1>
      <h3>
          ${originPlace} - ${destinationPlace}
      </h3>

      <h3>
        Date: ${outboundDate}
      </h3>
      <h4>
        Class: ${transportClass} |
        Number of adults: ${numOfAdults}
          <#if numOfChildren != "0">
            | Number of children: ${numOfChildren}
          </#if>
          <#if numOfInfants != "0">
            | Number of infants: ${numOfInfants}
          </#if>
      </h4>
      <a href="/home" class="btn btn-light btn-lg"> Return </a>
    </div>
  </div>
  <div class="row">
      <#list itineraries.itineraryDetail as intineraryDetail>
          <#list itineraries.leg as leg>
              <#if intineraryDetail.outboundLegId == leg.legId>
                <div class="col-md-6 offset-md-3 resultFlight rounded-lg">
                  <div class="row" style="height: 200px;">
                    <div class="col-md-2">
                        <#if leg.legCarriers?size == 1>
                            <#list itineraries.carrier as carrier>
                                <#if leg.legCarriers[0].carrierId == carrier.carrierId>
                                  <div class="logo" style="margin-top: 45%">
                                    <img alt="" src="${carrier.imageUrl}">
                                  </div>
                                </#if>
                            </#list>
                        <#else>
                          <div class="logoInscription " style="margin-top: 55%">
                              <#list leg.legCarriers as legCarrier>
                                  <#list itineraries.carrier as carrier>
                                      <#if legCarrier.carrierId == carrier.carrierId>
                                          <#if !(legCarrier_has_next)>
                                            <h5 class="d-inline"
                                                style="font-family: 'Tonto', serif;">
                                                ${carrier.name}
                                            </h5>
                                          <#else>
                                            <h5 class="d-inline"
                                                style="font-family: 'Tonto', serif;">
                                                ${carrier.name} +
                                            </h5>
                                          </#if>
                                      </#if>
                                  </#list>
                              </#list>
                          </div>
                        </#if>
                    </div>
                    <div class="col-md-2 text-center">
                      <h1 style="margin-top: 40%; font-family: 'Tonto', serif;">
                          ${leg.departure?substring(11,16)}
                      </h1>
                        <#list itineraries.place as place>
                            <#if place.placeId == leg.originStation>
                              <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                                  ${place.code}
                              </h5>
                            </#if>
                        </#list>
                    </div>
                    <div class="col-md-3 text-center">
                      <h4 style="margin-top: 20%; font-family: 'Tonto', serif;">
                          ${(leg.duration/60)?int} h ${leg.duration%60} min
                      </h4>
                      <img alt="" src="img/arrow.png" class="img-fluid">
                        <#if leg.stops?size == 0>
                          <h4 style="font-family: 'Tonto', serif; color: green">
                            Direct
                          </h4>
                        <#elseif leg.stops?size == 1>
                          <h4 style="font-family: 'Tonto', serif; color: red">
                            1 stop
                          </h4>
                        <#else>
                          <h4 style="font-family: 'Tonto', serif; color: red">
                              ${leg.stops?size} stops
                          </h4>
                        </#if>
                    </div>
                    <div class="col-md-2 text-center">
                      <h1 style="margin-top: 40%; font-family: 'Tonto', serif;">
                          ${leg.arrival?substring(11,16)}
                      </h1>
                        <#list itineraries.place as place>
                            <#if place.placeId == leg.destinationStation>
                              <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                                  ${place.code}
                              </h5>
                            </#if>
                        </#list>
                    </div>
                    <div class="col-md-3 text-center">
                      <p style="margin-top: 15%; margin-bottom: 0; color: dimgrey">${intineraryDetail.priceOptions?size}
                        deals from</p>
                      <h3><strong>
                              <#if intineraryDetail.outboundLegId == leg.legId>
                                  ${intineraryDetail.priceOptions[0].price}
                              </#if>
                        </strong> zł
                      </h3>
                      <a href="#" class="btn btn-success btn-lg" style="font-size: 25px">
                        Select </a>
                    </div>
                  </div>
                </div>
                <div class="w-100"></div>
              </#if>
          </#list>
      </#list>
  </div>
</div>
<#include "footer.ftlh">