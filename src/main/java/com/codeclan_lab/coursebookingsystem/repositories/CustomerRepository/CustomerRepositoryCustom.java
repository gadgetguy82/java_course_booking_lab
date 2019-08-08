package com.codeclan_lab.coursebookingsystem.repositories.CustomerRepository;

import com.codeclan_lab.coursebookingsystem.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

  List<Customer> findCustomersByCourseId(Long courseId);

  List<Customer> findCustomersByTownAndCourseId(String town, Long courseId);
}
