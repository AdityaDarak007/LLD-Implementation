package com.ecom.ecommerce.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Product extends BaseModel{
    private String name;
    private String description;
    private double price;
}
