package com.seth.service;

import com.seth.dao.FlightBookingDao;
import com.seth.entity.FlightBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightBookingServiceImpl implements FlightBookingService{

    @Autowired
    FlightBookingDao repository;


    public String saveBooking(FlightBooking booking) {
        return repository.saveBooking(booking);
    }


    public List<FlightBooking> fetchBookings() {
        return repository.fetchBooking();
    }


    public FlightBooking fetchBookingsById(int bookingId) {
        return repository.fetchBookingByID(bookingId);
    }


    public String deleteBookingsById(int bookingId) {
        return repository.deleteBookingByID(bookingId);
    }


    public String updateBookings(FlightBooking booking) {
        return repository.updateBooking(booking);
    }
}
