package com.flightbooking.service;

import com.flightbooking.entity.Airline;
import com.flightbooking.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public Airline addAirline(Airline airline) {
        return airlineRepository.save(airline);
    }
}
