package edu.northeastern.cs5500.delivery.model.user;

import lombok.Data;

// credit card class, may be used in the future to validate credit card info
@Data
public class Payment {
    private String cardNumber;
    private String cardHolderName;
}
