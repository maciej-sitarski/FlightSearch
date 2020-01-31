<#include "navbar.ftlh">
<div class="container-fluid">
  <div class="row home">
    <div class="col-md-7 " style="margin-top: 11%; margin-left: auto; margin-right: auto;">
      <h1 style="font-family: 'Tonto', serif; font-size: 90px; color: #0F076A"><strong>
          Where do you want to fly?
        </strong></h1>
    </div>
    <form action="/searchList?from=from&to=to&outboundDate=outboundDate&inboundDate=inboundDate&class=class&numberOfAdults=numberOfAdults&numberOfChildren=numberOfChildren&numberOfInfants=numberOfInfants" method="get" class="col-md-11 rounded-lg" style="margin-left: auto; margin-right: auto;height: 330px; background-color: #03002E">
      <div class="form-check form-check-inline" style="margin-top: 25px; margin-left: 40px; margin-right: 30px">
        <input class="form-check-input" type="radio"  value="option1" id="oneWay" name="inlineRadioOptions" checked="checked" onclick="secondCheckOneWayFlight(this)">
        <label class="form-check-label" for="oneWay">One way</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" id="return" name="inlineRadioOptions" value="option2" onclick="checkOneWayFlight(this)">
        <label class="form-check-label" for="return">Return </label>
      </div>
      <div class="form-row" style="margin-left: 35px; margin-top: 25px">
        <div class="col-md-3">
          <label style="color: white">From</label>
          <input type="text" placeholder="Gdańsk(GDN)" class="form-control" name="from" style="height: 50px; font-size: 25px"  required>
        </div>
        <div class="col-md-3">
          <label style="color: white">To</label>
          <input type="text" placeholder="Warszawa(WAW)" class="form-control" name="to" style="height: 50px; font-size: 25px" required>
        </div>
        <div class="col-md-2">
          <label style="color: white">Depart</label>
          <input type="date" placeholder="" class="form-control" name="outboundDate" style="height: 50px; font-size: 25px" required>
        </div>

        <div class="col-md-2">
          <label style="color: white" >Return</label>
          <input id="backFlight" type="date" class="form-control" name="inboundDate" style="height: 50px; font-size: 25px" disabled>
        </div>
        <div class="col-md-2">
          <label style="color: white">Class</label>
          <input type="text" class="form-control" placeholder="economy" name="class" style="height: 50px; font-size: 25px" required>
        </div>
      </div>
      <div class="form-row" style="margin-left: 35px; margin-top: 35px">
        <div class="col-md-1">
          <label style="color: white">Number of adults</label>
          <input type="number" min="1" max="10" value="1" class="form-control" name="numberOfAdults" style="height: 50px; font-size: 25px" required>
        </div>
        <div class="col-md-1">
          <label style="color: white">Number of children</label>
          <input type="number" min="0" max="10" value="0" class="form-control" name="numberOfChildren" style="height: 50px; font-size: 25px" required>
        </div>
        <div class="col-md-1">
          <label style="color: white">Number of infants</label>
          <input type="number" min="0" max="10" value="0" class="form-control" name="numberOfInfants" style="height: 50px; font-size: 25px" required>
        </div>
        <div class="col-md-4 text-center offset-md-1">
          <button class="btn btn-success"  type="submit" style=" height: 70px; font-size: 35px; margin-top: 15px;">
            Search flights
          </button>
        </div>
      </div>
    </form>
    <div class="col-md-12" style="height: 150px"></div>
  </div>
</div>


<#include "footer.ftlh">


