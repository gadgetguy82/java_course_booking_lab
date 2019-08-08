package com.codeclan_lab.coursebookingsystem.repositories.CustomerRepository;

import com.codeclan_lab.coursebookingsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {

}
