package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String name;

    private int rowNo;

    private int columnNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
}
