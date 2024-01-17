package com.flightbooking.controller;

import com.customer.paymentservice.model.PaymentRequest;
import com.flightbooking.dto.BookingDTO;
import com.flightbooking.dto.PaymentMode;
import com.flightbooking.dto.PaymentResponse;
import com.flightbooking.entity.Flight;
import com.flightbooking.entity.Seat;
import com.flightbooking.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/flights")
    public ResponseEntity<?> getFlights(){
        List<Flight> flights = flightRepository.findAll();
        return new ResponseEntity<>(flights, HttpStatus.ACCEPTED);
    }

    @PostMapping("/addFlight")
    public ResponseEntity<?> addFlight(@RequestBody Flight flight){
        flightRepository.save(flight);
        return new ResponseEntity<>(flight,HttpStatus.CREATED);
    }

    @PostMapping("/bookFlight")
    public ResponseEntity<?> bookFlight( @RequestParam long customerId,
                                         @RequestParam Long flight_id) {
        Optional<Flight> ob = flightRepository.findById(flight_id);
        if (ob.isEmpty()) {
            return new ResponseEntity<>("No Such Flight Available",HttpStatus.ACCEPTED);
        }

        Flight flight = ob.get();
        Optional<Integer> fareOptional = flight.getSeats().stream()
                .filter(Seat::isAvailable)
                .map(Seat::getFare)
                .findAny();

        if (fareOptional.isEmpty()) {
            return new ResponseEntity<>("No Seat Available",HttpStatus.ACCEPTED);
        }
        Long fareLong = (long)fareOptional.get();
        PaymentRequest paymentRequest = new PaymentRequest(1234L,fareLong,"1234567",PaymentMode.DEBIT_CARD);


        // Make a call to the payment service to process the payment
        PaymentResponse paymentResponse = processPayment(paymentRequest);

        if (paymentResponse != null) {
            // If payment is successful, create a BookingDTO
            BookingDTO bookingDTO = new BookingDTO();
            bookingDTO.setPaymentId(paymentResponse.getPaymentId());
            bookingDTO.setAmount(paymentResponse.getAmount());
            // You need to set the customerId based on your logic
            // For now, let's assume a hardcoded value, you might get it from the logged-in user or elsewhere
            bookingDTO.setCustomerId(customerId);

            // Update the customer service with booking history using the created BookingDTO
            updateBookingHistory(bookingDTO);

            return new ResponseEntity<>("Booking Successful", HttpStatus.CREATED);
        } else {
            // If payment fails, return an error response
            return new ResponseEntity<>("Payment failed. Please try again.", HttpStatus.BAD_REQUEST);
        }
    }

    private void updateBookingHistory(BookingDTO bookingDTO) {
        String customerServiceUrl = "http://localhost:8060/api/customers/addBooking";

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<BookingDTO> requestEntity = new HttpEntity<>(bookingDTO, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                customerServiceUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Booking history updated successfully");
        } else {
            System.out.println("Failed to update booking history. Status code: " + responseEntity.getStatusCodeValue());
        }
    }


    private PaymentResponse processPayment(PaymentRequest paymentRequest) {
        String paymentServiceUrl = "http://localhost:8060/v1/api/payments/doPayment";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PaymentRequest> requestEntity = new HttpEntity<>(paymentRequest, headers);

        ResponseEntity<PaymentResponse> paymentResponseEntity = restTemplate.postForEntity(
                paymentServiceUrl,
                requestEntity,
                PaymentResponse.class
        );

        if (paymentResponseEntity.getStatusCode() == HttpStatus.OK) {
            PaymentResponse paymentResponse = paymentResponseEntity.getBody();

            // Check if the payment status is SUCCESS
            return paymentResponse;
        } else {
            // Handle non-OK status code if needed
            return null;
        }
    }
}
