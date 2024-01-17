package com.flightsearchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightsearchservice.entity.Flight;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSearchRepository extends JpaRepository<Flight, Long> {

}
