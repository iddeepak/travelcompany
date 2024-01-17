
package com.customer.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest implements Serializable {

    private long bookingId;
    private long amount;
    private String transactionNumber;
    private PaymentMode paymentMode;

}
