package com.codeclan_lab.coursebookingsystem.repositories.CourseRepository;

import com.codeclan_lab.coursebookingsystem.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {
  List<Course> findCoursesByCustomerId(Long customerId);
}
