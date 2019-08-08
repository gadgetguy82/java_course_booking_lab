package com.codeclan_lab.coursebookingsystem.controllers;

import com.codeclan_lab.coursebookingsystem.models.Booking;
import com.codeclan_lab.coursebookingsystem.repositories.BookingRepository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

  @Autowired
  BookingRepository bookingRepository;

  @GetMapping(value = "/on/{date}")
  public List<Booking> findBookingsByDate(@PathVariable String date) {
    return bookingRepository.findBookingsByDate(date);
  }
}
