package com.ecom.ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class OrderDetail extends BaseModel {
    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
    private int quantity;
}
