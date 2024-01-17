
package com.customer.paymentservice.controller;

import com.customer.paymentservice.model.PaymentRequest;
import com.customer.paymentservice.model.PaymentResponse;
import com.customer.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public PaymentResponse processPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.processPayment(paymentRequest);
    }

    @GetMapping("/getPaymentDetails")
    public ResponseEntity<PaymentResponse> getPaymentDetailsByBookingNumber(
            @RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(
                paymentService.getPaymentDetailsByBookingId(id),
                HttpStatus.OK);
    }
}
