package com.flightbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse implements Serializable{
    private long paymentId;
    private String status;
    private PaymentMode paymentMode;
    private long amount;
    private Instant paymentDate;
    private long bookingId;

    public PaymentResponse(int paymentId, String status, PaymentMode paymentMode, int amount, Instant paymentDate, int bookingId) {
        this.paymentId = paymentId;
        this.status = status;
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.bookingId = bookingId;
    }
}
