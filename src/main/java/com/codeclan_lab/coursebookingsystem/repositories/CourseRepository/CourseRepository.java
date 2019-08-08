package com.codeclan_lab.coursebookingsystem.repositories.CourseRepository;

import com.codeclan_lab.coursebookingsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {

  List<Course> findCoursesByRating(int rating);
}
