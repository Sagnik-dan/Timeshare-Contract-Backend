package com.travelsandleisure.timesharemanagement.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class TimeshareContractResponse {

    private Long contractId;

    private String contractNumber;

    private LocalDate purchaseDate;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal contractValue;

    private String status;

    private String clientName;

    private String hotelName;
}