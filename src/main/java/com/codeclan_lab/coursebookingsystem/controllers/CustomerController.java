package com.codeclan_lab.coursebookingsystem.controllers;

import com.codeclan_lab.coursebookingsystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

  @Autowired
  CustomerRepository customerRepository;

}
