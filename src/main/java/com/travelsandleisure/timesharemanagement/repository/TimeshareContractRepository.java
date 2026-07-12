package com.travelsandleisure.timesharemanagement.repository;

import com.travelsandleisure.timesharemanagement.entity.Client;
import com.travelsandleisure.timesharemanagement.entity.TimeshareContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeshareContractRepository extends JpaRepository<TimeshareContract, Long> {

}