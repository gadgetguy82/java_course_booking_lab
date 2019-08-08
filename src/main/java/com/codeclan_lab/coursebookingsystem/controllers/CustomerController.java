package com.codeclan_lab.coursebookingsystem.controllers;

import com.codeclan_lab.coursebookingsystem.models.Customer;
import com.codeclan_lab.coursebookingsystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

  @Autowired
  CustomerRepository customerRepository;

  @GetMapping(value = "/courses/{courseId}")
  public List<Customer> findCustomersByCourseId(@PathVariable Long courseId){
    return customerRepository.findCustomersByCourseId(courseId);
  }

  @GetMapping(value = "/located/{town}/taking/{courseId}")
  public List<Customer> findCustomersByTownAndCourseId(@PathVariable String town, @PathVariable Long courseId) {
    return customerRepository.findCustomersByTownAndCourseId(town, courseId);
  }

  @GetMapping(value = "/aged/{age}/located/{town}/taking/{courseId}")
  public List<Customer> findCustomersByMinimumAgeTownAndCourseId(@PathVariable int age, @PathVariable String town,
                                                                 @PathVariable Long courseId) {
    return customerRepository.findCustomersByMinimumAgeTownAndCourseId(age , town, courseId);
  }

}
