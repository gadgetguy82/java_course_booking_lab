package com.codeclan_lab.coursebookingsystem.repositories.BookingRepository;

import com.codeclan_lab.coursebookingsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {
}
