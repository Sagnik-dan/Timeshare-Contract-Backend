package com.travelsandleisure.timesharemanagement.controller;
import com.travelsandleisure.timesharemanagement.dto.TimeshareContractRequest;
import com.travelsandleisure.timesharemanagement.dto.TimeshareContractResponse;
import com.travelsandleisure.timesharemanagement.service.TimeshareContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class TimeshareContractController {

    private final TimeshareContractService contractService;

    @PostMapping
    public TimeshareContractResponse createContract(
            @RequestBody TimeshareContractRequest request) {

        return contractService.createContract(request);
    }

    @GetMapping
    public List<TimeshareContractResponse> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public TimeshareContractResponse getContractById(
            @PathVariable Long id) {

        return contractService.getContractById(id);
    }
}