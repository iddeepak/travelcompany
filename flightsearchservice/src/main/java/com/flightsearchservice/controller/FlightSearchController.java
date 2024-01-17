package com.flightsearchservice.controller;

import com.flightsearchservice.entity.Flight;
import com.flightsearchservice.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api/search")
public class FlightSearchController {

    @Autowired
    FlightSearchService flightSearchService;

    @GetMapping("/flights/{id}")
    public ResponseEntity<Flight> searchFlights(
            @PathVariable Long id) {
        Flight flight = flightSearchService.searchFlights(id).get();
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }
}
