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
  <script src="/js/filter.js"></script>
  <script src="/js/oauth.js"></script>
  <script src="/js/favouriteFlights.js"></script>


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
      <li class="nav-item mr-5 favourite" style="display: none">
        <a class="nav-link" href="/favouriteFlights"> <strong>Your flight </strong></a>
      </li>

      <li class="nav-item">
        <div class="loginButton">
          <button class="border-0 innerButton"
                  style="background-color: #E6FAF8; color: #0F076A; margin-top: 7px"
                  data-toggle="modal" data-target="#loginModal"><strong>Log
              in</strong></button>
        </div>

        <div class="logOutButton" style="display: none">
          <button onClick="logout()" class="innerButton border-0"
                  style="background-color: #E6FAF8; color: #0F076A; margin-top: 7px"><strong>Log
              out</strong></button>
        </div>
      </li>

    </ul>
  </div>
</nav>

<form id="form-login" role="form">
  <div class="modal fade" id="loginModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content" style="margin-top: 200px">
        <div class="modal-header" style="background-color: #60a3bc">
          <h2 class="modal-title" style="margin-left: auto; margin-right: auto; color: black" ;>Sign
            in, to manage your travel </h2>
        </div>
        <div class="modal-body" style="background-color:  #D6D7D7">
          <div class="unauthenticated">
            <a href="/login" class="fb btn" style="margin-top: 20px">
              <i class="fa fa-facebook fa-fw"></i> Login with Facebook
            </a>
          </div>
        </div>
        <div class="modal-footer" style="background-color: #D6D7D7;">
          <button data-dismiss="modal" type="button" class="btn" id="button"
                  style="margin-top: 15px; font-size: 17px; width: 30%; margin-left: auto; margin-right: auto">
            Return
          </button>
        </div>
      </div>
    </div>
  </div>
</form>
</body>
</html>

