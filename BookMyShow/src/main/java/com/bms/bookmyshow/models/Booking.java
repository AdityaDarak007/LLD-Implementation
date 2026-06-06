package com.bms.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private User user;

    @OneToMany
    private List<ShowSeat> showSeats;
    @OneToMany
    private List<Payment> payment;

    private Date date;
    private int amount;

    @ManyToOne
    private Show show;

    @Enumerated(value = EnumType.STRING)
    private TicketStatus ticketStatus;
}
