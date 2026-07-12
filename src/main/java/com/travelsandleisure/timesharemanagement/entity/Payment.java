package com.travelsandleisure.timesharemanagement.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;



@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private BigDecimal amount;

    private LocalDate paymentDate;

    private String paymentMode;

    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private TimeshareContract contract;
}