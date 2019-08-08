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

import java.util.List;

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
		assertEquals(new Long(5), course.getId());
	}

	@Test
	public void canCreateCustomer() {
		Customer customer = new Customer("Bob Smith", "Glasgow", 34);
		customerRepository.save(customer);
		assertEquals(new Long(4), customer.getId());
	}

	@Test
	public void canCreateBooking() {
		Course course = new Course("Ruby", "Edinburgh", 5);
		courseRepository.save(course);
		Customer customer = new Customer("Bob Smith", "Glasgow", 34);
		customerRepository.save(customer);
		Booking booking = new Booking("23-05-19", customer, course);
		bookingRepository.save(booking);
		assertEquals(new Long(5), booking.getId());
	}

	@Test
	public void canFindCoursesByRating() {
		List<Course> found = courseRepository.findCoursesByRating(5);
		assertEquals(new Long(1), found.get(0).getId());
	}

	@Test
	public void canFindCustomersByCourseId() {
		List<Customer> found = customerRepository.findCustomersByCourseId(1L);
		assertEquals(new Long(1), found.get(0).getId());
	}

	@Test
	public void canFindCoursesByCustomerId() {
		List<Course> found = courseRepository.findCoursesByCustomerId(1L);
		assertEquals(new Long(1), found.get(0).getId());
	}

	@Test
	public void canFindBookingsByDate() {
		List<Booking> found = bookingRepository.findBookingsByDate("12-04-19");
		assertEquals(new Long(2), found.get(0).getId());
	}

	@Test
	public void canFindCustomersByTownAndCourseId() {
		List<Customer> found = customerRepository.findCustomersByTownAndCourseId("Edinburgh", 1L);
		assertEquals(new Long(1), found.get(0).getId());
	}

	@Test
	public void canFindCustomersByMinimumAgeTownAndCourseId() {
		List<Customer> found = customerRepository.findCustomersByMinimumAgeTownAndCourseId(20, "Edinburgh", 1L);
		assertEquals(new Long(1), found.get(0).getId());
	}

	@Test
	public void canFindCustomersByMinimumAgeTownAndCourseIdIgnoringCaseSensitivity() {
		List<Customer> found = customerRepository.findCustomersByMinimumAgeTownAndCourseId(20, "eDinBuRgh", 1L);
		assertEquals(new Long(1), found.get(0).getId());
	}
}
