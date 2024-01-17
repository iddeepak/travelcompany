package com.flightsearchservice.service;

import java.util.Optional;

import com.flightsearchservice.entity.Flight;

public interface FlightSearchService {

    public Optional<Flight> searchFlights(Long id);
}