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
            | Number of adults: ${numOfChildren}
          </#if>
          <#if numOfInfants != "0">
            | Number of adults: ${numOfInfants}
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
                    <div class="col-md-3">
                        <#if leg.legCarriers?size == 1>
                            <#list itineraries.carrier as carrier>
                                <#if leg.legCarriers[0] == carrier.id>
                                  <div class="logo ">
                                    <img alt="" src="${carrier.imageUrl}">
                                  </div>
                                </#if>
                            </#list>
                        <#else>
                          <div class="logoInscription ">
                              <#list leg.legCarriers as legCarrier>
                                  <#list itineraries.carrier as carrier>
                                      <#if legCarrier == carrier.id>
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
                      <h1 style="margin-top: 50%; font-family: 'Tonto', serif;">
                          ${leg.departure?substring(11,16)}
                      </h1>
                        <#list itineraries.place as place>
                            <#if place.id == leg.originStation>
                              <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                                  ${place.code}
                              </h5>
                            </#if>
                        </#list>
                    </div>
                    <div class="col-md-2 text-center">
                      <h5 style="margin-top: 50%; font-family: 'Tonto', serif;">
                          ${(leg.duration/60)?int} h ${leg.duration%60} min
                      </h5>
                      <h2>
                        ----------->
                      </h2>
                        <#if leg.stops?size == 0>
                          <h5 style="font-family: 'Tonto', serif; color: green">
                            Direct
                          </h5>
                        <#elseif leg.stops?size == 1>
                          <h5 style="font-family: 'Tonto', serif; color: red">
                            1 stop
                          </h5>
                        <#else>
                          <h5 style="font-family: 'Tonto', serif; color: red">
                              ${leg.stops?size} stops
                          </h5>
                        </#if>
                    </div>
                    <div class="col-md-2 text-center">
                      <h1 style="margin-top: 50%; font-family: 'Tonto', serif;">
                          ${leg.arrival?substring(11,16)}
                      </h1>
                        <#list itineraries.place as place>
                            <#if place.id == leg.destinationStation>
                              <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                                  ${place.code}
                              </h5>
                            </#if>
                        </#list>
                    </div>
                    <div class="col-md-3 text-center">
                      <p style="margin-top: 20%; margin-bottom: 0; color: dimgrey">${intineraryDetail.priceOptions?size} deals from</p>
                      <h3><strong>
                            <#if intineraryDetail.outboundLegId == leg.legId>
                              ${intineraryDetail.priceOptions[0].price}
                            </#if>
                        </strong> zł
                      </h3>
                      <a href="#" class="btn btn-success btn-lg" style="font-size: 25px"> Select </a>
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