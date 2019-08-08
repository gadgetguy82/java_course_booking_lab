package com.codeclan_lab.coursebookingsystem;

import com.codeclan_lab.coursebookingsystem.models.Course;
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

}
