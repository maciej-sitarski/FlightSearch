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