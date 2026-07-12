package com.travelsandleisure.timesharemanagement.repository;

import com.travelsandleisure.timesharemanagement.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Client, Long> {

}