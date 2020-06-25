const mymap = L.map('mapid').setView([41.8919300, 12.5113300], 5);

L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    maxZoom: 18,
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
        '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
        'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'sk.eyJ1IjoiYmFydGVraXBpb3RyZWsiLCJhIjoiY2s5dTdnaDVuMDU0eTNsbzV6ejVlanZhZiJ9.TkUkRY9glXzMQB73J1-c4A',
}).addTo(mymap);

let numberOfPoints = document.getElementById("airportsInfo").getAttribute(
    'data-pointNumbers');

let listOfAirports = [];
let listOfAirportsNames = [];
for (let i = 0; i < numberOfPoints; i++) {
    let airportLatitude = document.getElementById("airportsInfo").getAttribute(
        'data-placeLatitude' + i);
    let airportLongitude = document.getElementById("airportsInfo").getAttribute(
        'data-placeLongitude' + i);
    let airportName = document.getElementById("airportsInfo").getAttribute(
        'data-placeName' + i);

    const marker = L.marker([airportLatitude, airportLongitude]).addTo(mymap);
    const contentOfPopup =
        '<div class="text-center">' +
        '<p style="display: inline; font-size: 15px">' + airportName + ' </p>' +
        '</div>';
    marker.bindPopup(contentOfPopup);

    let airport = [airportLatitude, airportLongitude];
    listOfAirports.push(airport);
    listOfAirportsNames.push(airportName);
}


let listOfCorners = [];
for (let i = 0; i < listOfAirports.length-1; i++) {
    let polyline = L.polyline([
        listOfAirports[i],
        listOfAirports[i+1]],{color: 'blue'}
    ).addTo(mymap);
    let departureTime = document.getElementById("airportsInfo").getAttribute(
    'data-departureDateTime'+ i);
    let arrivalTime = document.getElementById("airportsInfo").getAttribute(
        'data-arrivalDateTime' + i);

    const contentOfPopup =
        '<div class="text-center">' +
        '<p style="display: inline; font-size: 15px">' + listOfAirportsNames[i]+ ' - </p>' +
        '<p style="display: inline; font-size: 15px">' + listOfAirportsNames[i+1]+ '</p>' +
        '<br/>' +
        '<p style="display: inline; font-size: 15px">' + departureTime+ ' - </p>' +
        '<p style="display: inline; font-size: 15px">' + arrivalTime+ '</p>' +
        '</div>';
    polyline.bindPopup(contentOfPopup, {
        minWidth: 400
    })
}

for (let i = 0; i < listOfAirports.length; i++) {
    let corner = L.latLng(listOfAirports[i])
    listOfCorners.push(corner)
}
console.log(listOfCorners)
bounds = L.latLngBounds(listOfCorners);
mymap.flyToBounds(bounds, {
    padding:[30,30]
});

