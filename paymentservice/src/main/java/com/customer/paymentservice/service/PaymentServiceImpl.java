package com.customer.paymentservice.service;

import java.time.Instant;

import com.customer.paymentservice.entity.Payment;
import com.customer.paymentservice.model.PaymentMode;
import com.customer.paymentservice.model.PaymentRequest;
import com.customer.paymentservice.model.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.paymentservice.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details: {}", paymentRequest);

        Payment payment = Payment.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .bookingId(paymentRequest.getBookingId())
                .amount(paymentRequest.getAmount())
                .build();

        paymentRepository.save(payment);

        log.info("Payment Completed with Id: {}", payment.getPaymentId());

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPaymentId(payment.getPaymentId());
        paymentResponse.setAmount(paymentRequest.getAmount());
        return paymentResponse;

    }

    @Override
    public PaymentResponse getPaymentDetailsByBookingId(Long bookingId) {
        log.info("Getting payment details for the Booking Id: {}", bookingId);

        Payment payment = paymentRepository.findById(bookingId).get();

        PaymentResponse paymentResponse = PaymentResponse.builder()
                .paymentId(payment.getPaymentId())
                .paymentMode(PaymentMode.valueOf(payment.getPaymentMode()))
                .paymentDate(payment.getPaymentDate())
                .bookingId(payment.getBookingId())
                .status(payment.getPaymentStatus())
                .amount(payment.getAmount())
                .build();

        return paymentResponse;
    }

}
