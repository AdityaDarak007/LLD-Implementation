package com.example.quickcommerce.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task extends BaseModel{
    private long customerId;
    @Embedded
    private Location pickupLocation;
}
