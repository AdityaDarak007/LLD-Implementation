package com.example.quickcommerce.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Partner extends BaseModel{
    private String name;
    @Embedded
    private Location currentLocation;
}
