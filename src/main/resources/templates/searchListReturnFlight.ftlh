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
        Outbound date: ${outboundDate} | Inbound date: ${inboundDate}
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
      <#list itineraries.itineraryDetailApi as intineraryDetail>
          <#list itineraries.legApi as legApi>
              <#if intineraryDetail.outboundLegId == legApi.legId>
                <div class="col-md-6 offset-md-3 resultFlightReturn rounded-lg">
                  <div class="row" style="height: 200px;">
                    <div class="col-md-3">
                        <#if legApi.legCarriers?size == 1>
                            <#list itineraries.carrierApi as carrierApi>
                                <#if legApi.legCarriers[0] == carrierApi.id>
                                  <div class="logo ">
                                    <img alt="" src="${carrierApi.imageUrl}">
                                  </div>
                                </#if>
                            </#list>
                        <#else>
                          <div class="logoInscription ">
                              <#list legApi.legCarriers as legCarrier>
                                  <#list itineraries.carrierApi as carrierApi>
                                      <#if legCarrier == carrierApi.id>
                                          <#if !(legCarrier_has_next)>
                                            <h5 class="d-inline"
                                                style="font-family: 'Tonto', serif;">
                                                ${carrierApi.name}
                                            </h5>
                                          <#else>
                                            <h5 class="d-inline"
                                                style="font-family: 'Tonto', serif;">
                                                ${carrierApi.name} +
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
                          ${legApi.departure?substring(11,16)}
                      </h1>
                        <#list itineraries.placeApi as placeApi>
                            <#if placeApi.id == legApi.originStation>
                              <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                                  ${placeApi.code}
                              </h5>
                            </#if>
                        </#list>
                    </div>
                    <div class="col-md-2 text-center">
                      <h5 style="margin-top: 50%; font-family: 'Tonto', serif;">
                          ${(legApi.duration/60)?int} h ${legApi.duration%60} min
                      </h5>
                      <h2>
                        ----------->
                      </h2>
                        <#if legApi.stops?size == 0>
                          <h5 style="font-family: 'Tonto', serif; color: green">
                            Direct
                          </h5>
                        <#elseif legApi.stops?size == 1>
                          <h5 style="font-family: 'Tonto', serif; color: red">
                            1 stop
                          </h5>
                        <#else>
                          <h5 style="font-family: 'Tonto', serif; color: red">
                              ${legApi.stops?size} stops
                          </h5>
                        </#if>
                    </div>
                    <div class="col-md-2 text-center">
                      <h1 style="margin-top: 50%; font-family: 'Tonto', serif;">
                          ${legApi.arrival?substring(11,16)}
                      </h1>
                        <#list itineraries.placeApi as placeApi>
                            <#if placeApi.id == legApi.destinationStation>
                              <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                                  ${placeApi.code}
                              </h5>
                            </#if>
                        </#list>
                    </div>
                    <div class="col-md-3 text-center">
                      <p style="margin-top: 60%; margin-bottom: 0; color: dimgrey">${intineraryDetail.priceOptionApis?size}
                        deals from</p>
                      <h3><strong>
                              <#if intineraryDetail.outboundLegId == legApi.legId>
                                  ${intineraryDetail.priceOptionApis[0].price}
                              </#if>
                        </strong> zł
                      </h3>
                    </div>
                  </div>
                </div>
                <div class="w-100"></div>
              <#elseif intineraryDetail.inboundLegId == legApi.legId>
                <div class="col-md-6 offset-md-3 resultFlightReturn2 rounded-lg">
                  <div class="row" style="height: 200px;">
                    <div class="col-md-3">
                        <#if legApi.legCarriers?size == 1>
                            <#list itineraries.carrierApi as carrierApi>
                                <#if legApi.legCarriers[0] == carrierApi.id>
                                  <div class="logo ">
                                    <img alt="" src="${carrierApi.imageUrl}">
                                  </div>
                                </#if>
                            </#list>
                        <#else>
                          <div class="logoInscription ">
                              <#list legApi.legCarriers as legCarrier>
                                  <#list itineraries.carrierApi as carrierApi>
                                      <#if legCarrier == carrierApi.id>
                                          <#if !(legCarrier_has_next)>
                                            <h5 class="d-inline"
                                                style="font-family: 'Tonto', serif;">
                                                ${carrierApi.name}
                                            </h5>
                                          <#else>
                                            <h5 class="d-inline"
                                                style="font-family: 'Tonto', serif;">
                                                ${carrierApi.name} +
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
                          ${legApi.departure?substring(11,16)}
                      </h1>
                        <#list itineraries.placeApi as placeApi>
                            <#if placeApi.id == legApi.originStation>
                              <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                                  ${placeApi.code}
                              </h5>
                            </#if>
                        </#list>
                    </div>
                    <div class="col-md-2 text-center">
                      <h5 style="margin-top: 50%; font-family: 'Tonto', serif;">
                          ${(legApi.duration/60)?int} h ${legApi.duration%60} min
                      </h5>
                      <h2>
                        ----------->
                      </h2>
                        <#if legApi.stops?size == 0>
                          <h5 style="font-family: 'Tonto', serif; color: green">
                            Direct
                          </h5>
                        <#elseif legApi.stops?size == 1>
                          <h5 style="font-family: 'Tonto', serif; color: red">
                            1 stop
                          </h5>
                        <#else>
                          <h5 style="font-family: 'Tonto', serif; color: red">
                              ${legApi.stops?size} stops
                          </h5>
                        </#if>
                    </div>
                    <div class="col-md-2 text-center">
                      <h1 style="margin-top: 50%; font-family: 'Tonto', serif;">
                          ${legApi.arrival?substring(11,16)}
                      </h1>
                        <#list itineraries.placeApi as placeApi>
                            <#if placeApi.id == legApi.destinationStation>
                              <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                                  ${placeApi.code}
                              </h5>
                            </#if>
                        </#list>
                    </div>
                    <div class="col-md-3 text-center">
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