package com.customer.paymentservice.repository;

import com.customer.paymentservice.entity.Payment;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
