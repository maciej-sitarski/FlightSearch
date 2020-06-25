package com.sitarski.maciej.flightsearch.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.jsonApi.jasonAirportInfoApi.AirportApi;
import com.sitarski.maciej.flightsearch.parser.AirportsInfoParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AirportInfoService {

    private final AirportsInfoParser airportsInfoParser;

    @Autowired
    public AirportInfoService(AirportsInfoParser airportsInfoParser) {
        this.airportsInfoParser = airportsInfoParser;
    }

    public AirportApi getAirportInfo(String iata) throws IOException, UnirestException {
        return airportsInfoParser.parseAirportInfo(iata);
    }
}
