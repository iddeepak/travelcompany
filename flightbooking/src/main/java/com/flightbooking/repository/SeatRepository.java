package com.flightbooking.repository;

import com.flightbooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    // Custom queries or methods can be added here if needed
}
