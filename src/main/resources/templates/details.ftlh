<#include "navbar.ftlh">

<div class="container-fluid" style="background-color: #F5F5F5">
  <div class="row">
    <div class="col-md-6 offset-md-3">
      <div class="row">
        <h2 style="margin-top: 20px; margin-bottom: 0">
          <strong>${informationCard.directionality} ${informationCard.departureTime?substring(0,10)}</strong>
        </h2>
        <div class="col-md-12  resultFlight rounded-lg" style="margin-top: 0">
          <div class="row" style="height: 200px;">
            <div class="col-md-2">
                <#if informationCard.carrierName?size == 1>
                  <div class="logo" style="margin-top: 45%">
                    <img alt="" src="${informationCard.carrierImageUrl[0]}">
                  </div>
                <#elseif informationCard.carrierName?size == 2>
                  <div class="logo" style="margin-top: 25%">
                    <img alt="" src="${informationCard.carrierImageUrl[0]}"
                         style="margin-bottom: 10%">
                    <img alt="" src="${informationCard.carrierImageUrl[1]}">
                  </div>
                <#else>
                  <div class="logoInscription " style="margin-top: 55%">
                      <#list informationCard.carrierName as carrierName>
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
                  ${informationCard.departureTime?substring(11,16)}
              </h1>
              <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                  ${informationCard.originPlaceCode}
              </h5>
            </div>
            <div class="col-md-3 text-center">
              <h4 style="margin-top: 20%; font-family: 'Tonto', serif;">
                  ${(informationCard.duration/60)?int} h ${informationCard.duration%60}
                min
              </h4>
              <img alt="" src="img/arrow.png" class="img-fluid">
                <#if informationCard.stops?size == 0>
                  <h4 style="font-family: 'Tonto', serif; color: green">
                    Direct
                  </h4>
                <#elseif informationCard.stops?size == 1>
                  <h4 style="font-family: 'Tonto', serif; color: red">
                    1 stop
                  </h4>
                <#else>
                  <h4 style="font-family: 'Tonto', serif; color: red">
                      ${informationCard.stops?size} stops
                  </h4>
                </#if>
            </div>
            <div class="col-md-2 text-center">
              <h1 style="margin-top: 40%; font-family: 'Tonto', serif;">
                  ${informationCard.arrivalTime?substring(11,16)}
              </h1>
              <h5 style="margin-top: 5%; font-family: 'Tonto', serif;">
                  ${informationCard.destinationPlaceCode}
              </h5>
            </div>
            <div class="col-md-3 text-center">
              <a href="javascript:history.back()" class="btn" id="button"
                 style="margin-top: 70px; width: 80%"> Return </a>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-6 offset-md-3">
      <h2 style="margin-top: 30px; margin-bottom: 10px">
        Book your tickets
      </h2>
        <#list detailsList as detail>
          <div class="col-md-12  border border-primary detailCard rounded-lg">
            <div class="row">
              <div class="col-md-4 text-center" style="margin-top: 18px; font-size: 30px">
                  ${detail.agentsName}
              </div>
              <div class="col-md-4 text-center inline-block" style="margin-top: 20px;  ">
                <h3><strong>${detail.price} zł</strong></h3>
              </div>
              <div class="col-md-4 text-center">
                <a href="${detail.uri}" class="btn btn-success btn-lg" style="font-size: 18px;margin-top: 20px; width: 50%">
                  Select </a>
              </div>
            </div>
          </div>
        </#list>
      <div class="w-100"></div>
    </div>

  </div>
  <div style="height: 400px">

  </div>
</div>



<#include "footer.ftlh">