package com.codeclan_lab.coursebookingsystem.models.projections;

import com.codeclan_lab.coursebookingsystem.models.Booking;
import com.codeclan_lab.coursebookingsystem.models.Course;
import com.codeclan_lab.coursebookingsystem.models.Customer;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedCourseAndCustomer", types = Booking.class)
public interface EmbedCourseAndCustomer {
  String getDate();
  List<Course> getCourse();
  List<Customer> getCustomer();
}
