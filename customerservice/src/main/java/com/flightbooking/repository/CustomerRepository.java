package com.flightbooking.repository;


import com.flightbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Custom queries or methods can be added here if needed
}




