package com.flightbooking.repository;

import com.flightbooking.entity.Schedule;
import com.flightbooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // Custom queries or methods can be added here if needed
}



