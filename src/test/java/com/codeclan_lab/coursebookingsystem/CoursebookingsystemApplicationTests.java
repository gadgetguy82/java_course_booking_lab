package com.codeclan_lab.coursebookingsystem;

import com.codeclan_lab.coursebookingsystem.models.Booking;
import com.codeclan_lab.coursebookingsystem.models.Course;
import com.codeclan_lab.coursebookingsystem.models.Customer;
import com.codeclan_lab.coursebookingsystem.repositories.BookingRepository.BookingRepository;
import com.codeclan_lab.coursebookingsystem.repositories.CourseRepository.CourseRepository;
import com.codeclan_lab.coursebookingsystem.repositories.CustomerRepository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursebookingsystemApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateCourse() {
		Course course = new Course("Ruby", "Edinburgh", 5);
		courseRepository.save(course);
		assertEquals(new Long(1), course.getId());
	}

	@Test
	public void canCreateCustomer() {
		Customer customer = new Customer("Bob Smith", "Glasgow", 34);
		customerRepository.save(customer);
		assertEquals(new Long(1), customer.getId());
	}

	@Test
	public void canCreateBooking() {
		Course course = new Course("Ruby", "Edinburgh", 5);
		courseRepository.save(course);
		Customer customer = new Customer("Bob Smith", "Glasgow", 34);
		customerRepository.save(customer);
		Booking booking = new Booking("23 May 2019", customer, course);
		bookingRepository.save(booking);
		assertEquals(new Long(1), booking.getId());
	}

}
