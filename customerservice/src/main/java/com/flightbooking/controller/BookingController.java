package com.flightbooking.controller;

import com.flightbooking.entity.Booking;
import com.flightbooking.entity.BookingDTO;
import com.flightbooking.entity.Customer;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/allBookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);

        if (optionalBooking.isPresent()) {
            return new ResponseEntity<>(optionalBooking.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addBooking")
    public ResponseEntity<String> addBooking(@RequestBody BookingDTO bookingDTO) {
        Customer customer = customerRepository.getReferenceById(bookingDTO.getCustomerId());

        Booking booking = new Booking();
        BeanUtils.copyProperties(bookingDTO, booking);

        // Set the customer after copying properties
        booking.setCustomer(customer);

        bookingRepository.save(booking);

        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }



    @PutMapping("/updateBooking/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking updatedBooking) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);

        if (optionalBooking.isPresent()) {
            Booking existingBooking = optionalBooking.get();
            // Update properties of existingBooking with those from updatedBooking
            // ...

            // Save the updated booking
            Booking savedBooking = bookingRepository.save(existingBooking);
            return new ResponseEntity<>(savedBooking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
