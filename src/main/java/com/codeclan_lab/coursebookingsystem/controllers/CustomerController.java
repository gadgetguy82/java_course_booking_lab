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
  List<Customer> findCustomersByCourseId(@PathVariable Long courseId){
    return customerRepository.findCustomersByCourseId(courseId);
  }
}
