package com.hotelbooking.controller;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("/hotels")
    public ResponseEntity<?> getFlights(){
        List<Hotel> hotels = hotelRepository.findAll();
        return new ResponseEntity<>(hotels, HttpStatus.ACCEPTED);
    }

    @PostMapping("/addHotel")
    public ResponseEntity<?> addFlight(@RequestBody Hotel hotel){
        hotelRepository.save(hotel);
        return new ResponseEntity<>(hotel,HttpStatus.CREATED);
    }

    /*
        Booking Hotel Functionality will be similar as of booking flight

     */
}
