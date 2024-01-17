package com.customer.paymentservice.service;

import com.customer.paymentservice.model.PaymentRequest;
import com.customer.paymentservice.model.PaymentResponse;

public interface PaymentService {

    PaymentResponse processPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByBookingId(Long bookingId);

}
