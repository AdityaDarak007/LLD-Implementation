package com.bms.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;

    @ManyToOne
    private Theatre theatre;

    @OneToMany
    private List<Seat> seats;
    @Enumerated(value = EnumType.STRING)
    private List<Feature> features;
}
