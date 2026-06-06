package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private double amount;
    private Date date;

    @Enumerated(value = EnumType.STRING)
    private PaymentGateway paymentGateway;

    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;

    private int refNumber;

    @Enumerated(value = EnumType.STRING)
    private PaymentMode paymentMode;

}
