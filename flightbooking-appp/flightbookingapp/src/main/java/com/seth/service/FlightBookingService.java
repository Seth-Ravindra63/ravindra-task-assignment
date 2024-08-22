package com.seth.service;

import com.seth.entity.FlightBooking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightBookingService {

    public String saveBooking(FlightBooking booking);
    public List<FlightBooking> fetchBookings();
    public FlightBooking fetchBookingsById(int bookingId);
    public String deleteBookingsById(int bookingId);
    public String updateBookings(FlightBooking booking);
}
