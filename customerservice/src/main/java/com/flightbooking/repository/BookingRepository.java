package com.flightbooking.repository;

import com.flightbooking.entity.Booking;
import com.flightbooking.entity.BookingDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
