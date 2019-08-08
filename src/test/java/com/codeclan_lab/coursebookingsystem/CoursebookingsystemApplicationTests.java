package com.codeclan_lab.coursebookingsystem;

import com.codeclan_lab.coursebookingsystem.models.Booking;
import com.codeclan_lab.coursebookingsystem.models.Course;
import com.codeclan_lab.coursebookingsystem.models.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursebookingsystemApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateCourse() {
		Course course = new Course("Ruby", "Edinburgh", 5);
		assertEquals("Ruby", course.getName());
	}

	@Test
	public void canCreateBooking() {
		Booking booking = new Booking("23 May 2019");
		assertEquals("23 May 2019", booking.getDate());
	}

	@Test
	public void canCreateCustomer() {
		Customer customer = new Customer("Bob Smith", "Glasgow", 34);
		assertEquals("Bob Smith", customer.getName());
	}
}
