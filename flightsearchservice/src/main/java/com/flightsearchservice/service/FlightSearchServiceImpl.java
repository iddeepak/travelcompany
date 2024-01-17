package com.flightsearchservice.service;

import java.util.Optional;

import com.flightsearchservice.entity.Flight;
import com.flightsearchservice.repository.FlightSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightSearchServiceImpl implements FlightSearchService {

    @Autowired
    FlightSearchRepository flightSearchRepository;

    public Optional<Flight> searchFlights(Long id) {
       return flightSearchRepository.findById(id);
    }

}
