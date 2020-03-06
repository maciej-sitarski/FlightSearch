function saveFavouriteFlight(legId, outboundDate) {
  var userFavouriteSearchForm = {
    userId: document.getElementById("principal").getAttribute('data-value'),
    legId: legId,
    searchForm: {
      originPlace: document.getElementById("searchForm").getAttribute(
          'data-originPlace'),
      destinationPlace: document.getElementById("searchForm").getAttribute(
          'data-destinationPlace'),
      outboundDate: outboundDate,
      transportClass: document.getElementById("searchForm").getAttribute(
          'data-transportClass'),
      numberOfAdults: document.getElementById("searchForm").getAttribute(
          'data-numberOfAdults'),
      numberOfChildren: document.getElementById("searchForm").getAttribute(
          'data-numberOfChildren'),
      numberOfInfants: document.getElementById("searchForm").getAttribute(
          'data-numberOfInfants')
    }
  };
  $.ajax({
    url: "/favouriteManage/save",
    method: "POST",
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(userFavouriteSearchForm),
    success: function () {
      location.reload();
    }
  });
}

function deleteFavouriteFlight(legId) {
  var userFavouriteSearchForm = {
    userId: document.getElementById("principal").getAttribute('data-value'),
    legId: legId,
    searchForm: null
  };
  $.ajax({
    url: "/favouriteManage/delete",
    method: "POST",
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(userFavouriteSearchForm),
    success: function () {
      location.reload();
    }
  });
}