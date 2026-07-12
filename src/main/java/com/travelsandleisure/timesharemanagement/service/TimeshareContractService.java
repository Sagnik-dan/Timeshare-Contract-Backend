package com.travelsandleisure.timesharemanagement.service;

import com.travelsandleisure.timesharemanagement.dto.TimeshareContractRequest;
import com.travelsandleisure.timesharemanagement.dto.TimeshareContractResponse;

import java.util.List;

public interface TimeshareContractService {

    TimeshareContractResponse createContract(
            TimeshareContractRequest request);

    List<TimeshareContractResponse> getAllContracts();

    TimeshareContractResponse getContractById(Long id);
}