package com.codeclan_lab.coursebookingsystem.components;

import com.codeclan_lab.coursebookingsystem.models.Booking;
import com.codeclan_lab.coursebookingsystem.models.Course;
import com.codeclan_lab.coursebookingsystem.models.Customer;
import com.codeclan_lab.coursebookingsystem.repositories.BookingRepository.BookingRepository;
import com.codeclan_lab.coursebookingsystem.repositories.CourseRepository.CourseRepository;
import com.codeclan_lab.coursebookingsystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  BookingRepository bookingRepository;

  @Autowired
  CourseRepository courseRepository;

  public DataLoader() {

  }

  public void run(ApplicationArguments args) {

    Course rubyCourse = new Course("Ruby", "Edinburgh", 5);
    courseRepository.save(rubyCourse);

    Customer katherine = new Customer("katherine", "Edinburgh", 23);
    customerRepository.save(katherine);

    Course javascriptCourse = new Course("JavaScript", "Edinburgh", 4);
    courseRepository.save(javascriptCourse);

    Course javaCourse = new Course("Java", "Glasgow", 5);
    courseRepository.save(javaCourse);

    Customer simon = new Customer("simon", "Glasgow", 35);
    customerRepository.save(simon);

    Booking booking1 = new Booking("23-05-19", katherine, rubyCourse);
    bookingRepository.save(booking1);

    Booking booking2 = new Booking("12-04-19", katherine, javaCourse);
    bookingRepository.save(booking2);

    Booking booking3 = new Booking("12-04-19", simon, javaCourse);
    bookingRepository.save(booking3);

    Booking booking4 = new Booking("16-08-19", simon, javascriptCourse);
    bookingRepository.save(booking4);



  }
}
