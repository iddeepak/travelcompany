package com.hotelbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);
	}
}
