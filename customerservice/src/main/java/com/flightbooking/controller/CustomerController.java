package com.flightbooking.controller;

import com.flightbooking.entity.Booking;
import com.flightbooking.entity.BookingDTO;
import com.flightbooking.entity.Customer;
import com.flightbooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomers(){
        List<Customer> flights = customerRepository.findAll();
        return new ResponseEntity<>(flights, HttpStatus.ACCEPTED);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        // Iterate through each booking and set the customer reference
        if (customer.getBookings() != null) {
            for (Booking booking : customer.getBookings()) {
                booking.setCustomer(customer);
            }
        }

        // Save the customer, and the cascade will save associated bookings
        customerRepository.save(customer);

        return new ResponseEntity<>("Successfully Added", HttpStatus.CREATED);
    }
}
