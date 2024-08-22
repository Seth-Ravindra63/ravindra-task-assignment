package com.seth.controller;

import com.seth.entity.FlightBooking;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.seth.service.FlightBookingService;
import java.util.List;
import java.util.Date;

@Controller
@RequestMapping("/booking")
public class FlightbookingController {
    @Autowired
    FlightBookingService service;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model m) {
        m.addAttribute("page", "home");
        return "home";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTodo(Model m) {
        m.addAttribute("page", "add");
        m.addAttribute("flightBooking", new FlightBooking());
        return "home";
    }

    @RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
    public String saveTodo(@ModelAttribute("flightBooking") FlightBooking c, Model m) {
        c.setDate(new Date());
        String bookingMsg = service.updateBookings(c);
        m.addAttribute("msg",bookingMsg);
        System.out.println(bookingMsg);
        return "redirect:/viewBooking";
    }

    @RequestMapping(value = "/viewBooking", method = RequestMethod.GET)
    public String fetchAllBookings(Model m) {
        List<FlightBooking> fetchBookings = service.fetchBookings();
        m.addAttribute("page", "viewBooking");
        m.addAttribute("allBookings",fetchBookings);
        System.out.println(fetchBookings);
        return "home";
    }

	/*@RequestMapping(value = "/viewBookingById/{id}", method = RequestMethod.GET)
	public String fetchBookingsByID(@PathVariable int id) {
		CustomerBooking fetchBookings = service.fetchBookingsById(id);
		System.out.println(fetchBookings);
		return "home";
	}*/

    @RequestMapping(value = "/deleteBookingById/{id}")
    public String deleteBookingByID(@PathVariable int id) {
        String msg = service.deleteBookingsById(id);
        System.out.println(msg);
        return "redirect:/viewBooking";
    }

    @RequestMapping(value = "/updateBooking/{id}")
    public String updateBooking(@PathVariable int id, Model m) {
        FlightBooking fetchBookings = service.fetchBookingsById(id);
        System.out.println("fetchBookings:::::" +fetchBookings);
        m.addAttribute("flightBooking",fetchBookings);
        m.addAttribute("page", "add");
        return "home";
    }

}
