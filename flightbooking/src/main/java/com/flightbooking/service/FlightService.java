package com.flightbooking.service;

import com.flightbooking.entity.Flight;
import com.flightbooking.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }
}
