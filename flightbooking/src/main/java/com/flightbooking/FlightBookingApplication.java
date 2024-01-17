package com.flightbooking;

import com.flightbooking.entity.Airline;
import com.flightbooking.entity.Flight;
import com.flightbooking.entity.Seat;
import com.flightbooking.service.AirlineService;
import com.flightbooking.service.FlightService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class FlightBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingApplication.class, args);

		// Adding default airline and flight for which you can book seat
	}
	@Bean
	public CommandLineRunner init(AirlineService airlineService, FlightService flightService) {
		return args -> {
			// Create an Airline
			Airline airline = new Airline();
			airline.setName("Sample Airline");

			// Save the Airline to the database
			airlineService.addAirline(airline);

			// Create a Flight
			Flight flight = new Flight();
			flight.setFlightNo("ABC123");
			flight.setAirline(airline);
			flight.setSeatCapacity(100);

			// Save the Flight to the database
			flightService.addFlight(flight);

			// Add some seats to the flight
			for (int i = 1; i <= 50; i++) {
				Seat seat = new Seat();
				seat.setSeatNumber("A" + i);
				seat.setFlight(flight);
				seat.setFare(50);
				flight.getSeats().add(seat);
			}

			// Save the updated Flight to the database
			flightService.addFlight(flight);
		};
	}
}
