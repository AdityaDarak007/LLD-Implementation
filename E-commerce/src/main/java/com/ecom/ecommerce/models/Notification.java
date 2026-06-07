package com.ecom.ecommerce.models;


import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Notification extends BaseModel{
    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;
    private NotificationStatus status;
}
