package com.seth.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FLIGHT_BOOKING")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingID;
    private int customerID;
    private String customerName;
    private Date date;
    public FlightBooking() {
        super();
        // TODO Auto-generated constructor stub
    }
    public FlightBooking(int bookingID, int customerID, String customerName, Date date) {
        super();
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.date = date;
    }
    public int getBookingID() {
        return bookingID;
    }
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "CustomerBooking [bookingID=" + bookingID + ", customerID=" + customerID + ", customerName="
                + customerName + ", date=" + date + "]";
    }



}
