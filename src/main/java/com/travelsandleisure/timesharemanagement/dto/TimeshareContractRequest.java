package com.travelsandleisure.timesharemanagement.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TimeshareContractRequest {

    private String contractNumber;

    private LocalDate purchaseDate;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal contractValue;

    private String status;

    private Long clientId;

    private Long hotelId;
}