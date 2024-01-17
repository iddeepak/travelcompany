package com.customer.paymentservice.model;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse implements Serializable {
    private long paymentId;
    private String status;
    private PaymentMode paymentMode;
    private long amount;
    private Instant paymentDate;
    private long bookingId;
}
