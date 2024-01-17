# Microservices System

This repository contains a collection of microservices that together form a distributed system for handling various functionalities related to a travel application. Each microservice is designed to perform specific tasks, contributing to the overall functionality of the system.

## List of Microservices

1. [Config Server](#config-server)
2. [Eureka Server](#eureka-server)
3. [API Gateway](#api-gateway)
4. [Identity Service](#identity-service)
5. [Customer Service](#customer-service)
6. [Flight Search Service](#flight-search-service)
7. [Flight Booking Service](#flight-booking-service)
8. [Hotel Booking Service](#hotel-booking-service)
9. [Payment Service](#payment-service)


## Config Server

Description: The Config Server microservice centralizes the configuration for all other microservices, ensuring that configurations are easily manageable and accessible.

## Eureka Server

Description: The Eureka Server microservice functions as a service registry and provides service discovery capabilities, enabling microservices to locate and communicate with each other.

## API Gateway

Description: The API Gateway microservice serves as an entry point for clients to interact with the entire system. It manages the routing and composition of various microservices' endpoints.

## Identity Service

Description: The Identity Service microservice is responsible for user authentication and authorization, ensuring secure access to the system's resources.

## Customer Service

Description: The Customer Service microservice is responsible for managing customer-related information, such as customer profiles, bookings, and other relevant data.

## Flight Search Service

Description: The Flight Search Service microservice specializes in searching for available flights based on specified criteria such as dates, destinations, and preferences.

## Flight Booking Service

Description: The Flight Booking Service microservice handles functionalities related to flight bookings, including searching for flights, making reservations, and managing booking details.

## Hotel Booking Service

Description: The Hotel Booking Service microservice manages hotel-related functionalities, including searching for available accommodations, making reservations, and handling booking details.

## Payment Service

Description: The Payment Service microservice handles payment processing for bookings made within the system, integrating with external payment gateways.

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/iddeepak/travelcompany.git
   cd travelcompany
## Necessary Requirements

Before you begin, make sure you have the following prerequisites installed:

1. **Java 17:**
   - Ensure that you have Java Development Kit (JDK) version 17 installed on your machine. You can download it from [Oracle](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or use a package manager like [SDKMAN!](https://sdkman.io/).

2. **Spring Boot 3.1.5:**
   - The microservices are built using Spring Boot. Make sure that you have Spring Boot version 3.1.5 configured in your project. You can include it in your project's build configuration file (e.g., pom.xml for Maven or build.gradle for Gradle).

   Example for Maven:

   ```xml
   <properties>
       <spring-boot.version>3.1.5</spring-boot.version>
   </properties>