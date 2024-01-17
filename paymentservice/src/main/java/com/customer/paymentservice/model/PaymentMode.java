package com.customer.paymentservice.model;

import java.io.Serializable;

public enum PaymentMode implements Serializable {
    CASH,
    PAYPAL,
    DEBIT_CARD,
    CREDIT_CARD,
    APPLE_PAY
}
