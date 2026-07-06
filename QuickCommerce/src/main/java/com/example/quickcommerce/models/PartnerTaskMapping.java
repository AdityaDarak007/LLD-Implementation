package com.example.quickcommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PartnerTaskMapping extends BaseModel{
    @ManyToMany
    private Partner partner;
    @ManyToOne
    private Task task;
}

