package com.seth.dao;

import javax.transaction.Transactional;

import com.seth.entity.FlightBooking;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class FlightBookingDao {

    private HibernateTemplate hibernateTemplate;

    @Transactional
    public String saveBooking(FlightBooking booking) {
        hibernateTemplate.save(booking);
        return ("Saved Customer booking with customer booking id:: "+ booking.getCustomerID());
    }

    public List<FlightBooking> fetchBooking() {
        List<FlightBooking> loadAll = hibernateTemplate.loadAll(FlightBooking.class);
        return loadAll;
    }

    public FlightBooking fetchBookingByID(int bookingId) {
        return hibernateTemplate.get(FlightBooking.class, bookingId);
    }

    @Transactional
    public String deleteBookingByID(int bookingId) {
        FlightBooking FlightBooking = hibernateTemplate.get(FlightBooking.class, bookingId);
        hibernateTemplate.delete(FlightBooking);
        return "Student with Booking id ::" + FlightBooking.getBookingID() + " deleted successfully.";
    }

    @Transactional
    public String updateBooking(FlightBooking booking) {
        hibernateTemplate.saveOrUpdate(booking);
        return "Student with Booking id ::" + booking.getBookingID() + " updated successfully.";
    }


    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

}
