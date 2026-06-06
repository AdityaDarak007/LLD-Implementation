package com.bms.bookmyshow.service;

import com.bms.bookmyshow.models.Booking;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    public Booking bookTicket();
}
