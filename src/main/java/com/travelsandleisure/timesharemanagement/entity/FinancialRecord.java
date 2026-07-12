package com.travelsandleisure.timesharemanagement.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;



@Entity
@Table(name = "financial_records")
public class FinancialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    private BigDecimal annualIncome;

    private Integer creditScore;

    private String riskCategory;

    private String employmentType;

    private LocalDate lastUpdated;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
}