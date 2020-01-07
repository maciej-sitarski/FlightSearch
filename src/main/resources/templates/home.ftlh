<#include "navbar.ftlh">
<div class="container-fluid">
  <div class="row home">
    <div class="col-md-6 " style="margin-top: 11%; margin-left: auto; margin-right: auto;">
      <h1 style="font-family: 'Tonto', serif; font-size: 90px; color: #0F076A"><strong>
          Dokąd chcesz lecieć?
        </strong></h1>
    </div>
    <form class="col-md-11 rounded" style="margin-left: auto; margin-right: auto;height: 300px; background-color: #03002E">
      <div class="form-check form-check-inline" style="margin-top: 25px; margin-left: 40px; margin-right: 30px">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" checked="checked" onclick="secondCheckOneWayFlight(this)">
        <label class="form-check-label" for="inlineRadio1">W jedną stronę</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2" onclick="checkOneWayFlight(this)">
        <label class="form-check-label" for="inlineRadio2">W obie strony </label>
      </div>
      <div class="form-row" style="margin-left: 35px; margin-top: 25px">
        <div class="col-md-3">
          <label for="validationCustom01" style="color: white">Skąd</label>
          <input type="text" placeholder="Gdańsk(GDN)" class="form-control" style="height: 50px; font-size: 25px"  required>
        </div>
        <div class="col-md-3">
          <label for="validationCustom02" style="color: white">Dokąd</label>
          <input type="text" placeholder="Warszawa(WAW)" class="form-control" style="height: 50px; font-size: 25px" required>
        </div>
        <div class="col-md-2">
          <label for="validationCustom02" style="color: white">Wylot</label>
          <input type="date" placeholder="" class="form-control" style="height: 50px; font-size: 25px" required>
        </div>

        <div class="col-md-2">
          <label for="validationCustom02" style="color: white" >Powrót</label>
          <input id="backFlight" type="date" class="form-control" style="height: 50px; font-size: 25px" disabled>
        </div>
<#--        <div class="col-md-2">-->
<#--          <label for="validationCustom02" style="color: white">Klasa</label>-->
<#--          <input type="text" class="form-control" placeholder="Ekonomiczna" style="height: 50px; font-size: 25px">-->
<#--        </div>-->
        <div class="col-md-2">
          <label for="validationCustom02" style="color: white">Ilość osób</label>
          <input type="number" min="1" max="10" value="1" class="form-control" style="height: 50px; font-size: 25px" required>
        </div>
      </div>
      <div class="row">
        <a class="col-md-3 offset-md-4 btn btn-primary" href="/searchList" style=" margin-top: 30px; margin-left: auto; margin-right: auto; width: 30px; height: 50px; font-size: 25px">
          Szukaj
        </a>
      </div>



    </form>
    <div class="col-md-12" style="height: 150px"></div>
  </div>
</div>


<#include "footer.ftlh">


