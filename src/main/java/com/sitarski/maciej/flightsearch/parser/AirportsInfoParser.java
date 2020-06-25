package com.sitarski.maciej.flightsearch.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sitarski.maciej.flightsearch.entity.ItineraryInquiry;
import com.sitarski.maciej.flightsearch.jsonApi.jasonAirportInfoApi.AirportApi;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.ItineraryApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AirportsInfoParser {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${API_Key}")
    private String API_Key;

    public AirportApi parseAirportInfo(String iata) throws UnirestException, IOException {

        logger.info("Parse json to airportApi");

        HttpResponse<String> response = Unirest.get(String.format("https://airport-info.p.rapidapi.com/airport?iata=%s", iata))
                .header("x-rapidapi-host", "airport-info.p.rapidapi.com")
                .header("x-rapidapi-key", API_Key)
                .asString();

        return objectMapper.readValue(response.getBody(), AirportApi.class);
    }
}
