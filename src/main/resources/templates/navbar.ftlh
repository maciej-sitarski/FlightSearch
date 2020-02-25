<!DOCTYPE html>
<html lang="pl">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
        crossorigin="anonymous">
  <!-- Our CSS -->

  <link rel="stylesheet" href="css/home.css">
  <link rel="stylesheet" href="css/navbar.css">
  <link rel="stylesheet" href="css/searchList.css">
  <link rel="stylesheet" href="css/selectList.css">
  <link rel="stylesheet" href="css/button.css">
  <title>FlightSearch</title>

  <link rel="stylesheet" href="/font/map.css" type="text/css">

  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
  <script src="/js/home.js"></script>
  <script src="/js/filter.js"></script>
</head>

<body>
<nav class="navbar navbar-expand-md ">
  <p class="navbar-brand" style="margin-left: 15%; font-family:sans-serif; font-size: 50px">
    <strong>
      Flight
    </strong>
  </p>
  <h1><span class="icon-flight-1"></span></h1>
  <p class="navbar-brand ml-2" style=" font-family: sans-serif; font-size: 50px;">
    <strong>
      Search
    </strong>
  </p>

  <button class="navbar-toggler navbar-light" type="button" data-toggle="collapse"
          data-target="#mainmenu" aria-controls="mainmenu" aria-expanded="false"
          aria-label="Przełącznik nawigacji">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="mainmenu">
    <ul class="navbar-nav" style="margin-left: auto; margin-right: 7%">
      <li class="nav-item mr-5">
        <a class="nav-link" href="/home"> <strong>Main site </strong></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-toggle="modal" data-target="#loginModal"><strong>Log
            in</strong></a>
      </li>
    </ul>
  </div>
</nav>

<#--<form id="form-login" role="form">-->
<#--  <div class="modal fade" id="loginModal" role="dialog">-->
<#--    <div class="modal-dialog">-->
<#--      <div class="modal-content">-->
<#--        <div class="modal-header">-->
<#--          <h4 class="modal-title">Prosimy o zalogowanie się </h4>-->
<#--        </div>-->
<#--        <div class="modal-body">-->
<#--          <label><strong>Adres email: </strong></label><br/>-->
<#--          <input name="email" id="email" type="text"><br/>-->
<#--          <label><strong>Hasło: </strong></label><br/>-->
<#--          <input name="password" id="password" type="password">-->
<#--        </div>-->
<#--        <div class="modal-footer">-->
<#--          <button type="button" id="login" class="btn btn-success"-->
<#--                  style="position: absolute; left: 20px;">Zaloguj się-->
<#--          </button>-->
<#--          <p style="position: absolute; left: 130px;">lub-->
<#--            <a class="registration" href="/registration">Utwórz konto </a>-->
<#--          </p>-->
<#--          <button type="button" class="btn btn-danger" data-dismiss="modal">Zamknij</button>-->
<#--        </div>-->
<#--      </div>-->
<#--    </div>-->
<#--  </div>-->
<#--</form>-->


</body>
</html>