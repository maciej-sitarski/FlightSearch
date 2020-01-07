function checkOneWayFlight(radio) {
  if (radio.checked) {
    document.getElementById("backFlight").disabled = false;
  }
}

function secondCheckOneWayFlight(radio) {
  if (radio.checked) {
    document.getElementById("backFlight").disabled = true;
  }
}