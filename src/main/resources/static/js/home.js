function checkOneWayFlight(radio) {
  if (radio.checked) {
    document.getElementById("backFlight").disabled = false;
    document.getElementById("backFlight").required = true;
  }
}

function secondCheckOneWayFlight(radio) {
  if (radio.checked) {
    document.getElementById("backFlight").disabled = true;
    document.getElementById("backFlight").required = false;
  }
}

$(function() {
  $("#originAutocompletePlace").autocomplete({
    source: "originPlaceAutocomplete",
    minLength: 2,
  });
});

$(function() {
  $("#destinationAutocompletePlace").autocomplete({
    source: "destinationPlaceAutocomplete",
    minLength: 2
  });
});

