package com.bms.bookmyshow.controller;

import com.bms.bookmyshow.dtos.BookingResponseDto;
import com.bms.bookmyshow.models.Booking;
import com.bms.bookmyshow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookingResponseDto bookTicket(BookingRequestDto bookingRequestDto){
        Booking booking = bookingService.bookTicket(bookingRequestDto);

        BookingResponseDto bookingResponseDto = new BookingResponseDto();

        return bookingResponseDto;
    }

}
