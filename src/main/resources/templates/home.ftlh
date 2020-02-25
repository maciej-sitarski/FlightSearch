<#include "navbar.ftlh">
<div class="container-fluid">
  <div class="row home" style="font-family: fantasy ">
    <div class="col-md-7 " style="margin-top: 11%; margin-left: auto; margin-right: auto;">
      <h1 style=" font-size: 90px; color: #0F076A"><strong>
          Where do you want to fly?
        </strong></h1>
    </div>
    <form
        action="/searchList"
        method="get" class="col-md-11 rounded-lg"
        style="margin-left: auto; margin-right: auto;height: 330px; background-color: #03002E">
      <div class="form-check form-check-inline"
           style="margin-top: 25px; margin-left: 40px; margin-right: 30px">
        <input class="form-check-input" type="radio" value="option1" id="oneWay"
               name="inlineRadioOptions" checked="checked" onclick="secondCheckOneWayFlight(this)">
        <label class="form-check-label" for="oneWay" style="font-size: 30px">One way</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" id="return" name="inlineRadioOptions"
               value="option2" onclick="checkOneWayFlight(this)">
        <label class="form-check-label" for="return" style="font-size: 30px">Return </label>
      </div>
      <div class="form-row" style="margin-left: 35px; margin-top: 15px">
        <div class="col-md-3">
          <label style="color: white; font-size: 20px">From</label>
          <input type="text" placeholder="Gdańsk(GDN)" class="form-control"  name="originPlace"
                 style="height: 50px; font-size: 25px" required>
        </div>
        <div class="col-md-3">
          <label style="color: white; font-size: 20px">To</label>
          <input type="text" placeholder="Warszawa(WAW)" class="form-control" name="destinationPlace"
                 style="height: 50px; font-size: 25px" required>
        </div>
        <div class="col-md-2">
          <label style="color: white; font-size: 20px">Depart</label>
          <input type="date" placeholder="" class="form-control" name="outboundDate"
                 style="height: 50px; font-size: 25px" required>
        </div>

        <div class="col-md-2">
          <label style="color: white; font-size: 20px">Return</label>
          <input id="backFlight" type="date" class="form-control" name="inboundDate"
                 style="height: 50px; font-size: 25px" disabled>
        </div>
        <div class="col-md-2">
          <label style="color: white; font-size: 20px">Class</label>
          <select class="form-control" id="class" name="transportClass" style="font-size: 24px; ">
            <option selected>economy</option>
            <option>business</option>
            <option>first</option>
          </select>
        </div>
      </div>
      <div class="form-row" style="margin-left: 35px; margin-top: 30px">
        <div class="col-md-1">
          <label style="color: white; font-size: 18px">Number of adults</label>
          <input type="number" min="1" max="10" value="1" class="form-control" name="numberOfAdults"
                 style="height: 50px; font-size: 25px" required>
        </div>
        <div class="col-md-1">
          <label style="color: white; font-size: 18px">Number of children</label>
          <input type="number" min="0" max="10" value="0" class="form-control"
                 name="numberOfChildren" style="height: 50px; font-size: 25px" required>
        </div>
        <div class="col-md-1">
          <label style="color: white; font-size: 18px">Number of infants</label>
          <input type="number" min="0" max="10" value="0" class="form-control"
                 name="numberOfInfants" style="height: 50px; font-size: 25px" required>
        </div>
        <div class="col-md-4 text-center offset-md-1">
          <button type="submit" id="searchingButton">
            Search flights
          </button>

        </div>
      </div>
    </form>
    <div class="col-md-12" style="height: 150px"></div>
  </div>
</div>
<#include "footer.ftlh">


