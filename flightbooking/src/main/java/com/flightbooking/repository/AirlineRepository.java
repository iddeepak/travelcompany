package com.flightbooking.repository;

import com.flightbooking.entity.Airline;
import com.flightbooking.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
    // Custom queries or methods can be added here if needed
}




