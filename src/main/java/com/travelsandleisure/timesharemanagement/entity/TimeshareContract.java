package com.travelsandleisure.timesharemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "timeshare_contracts")
public class TimeshareContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;

    private String contractNumber;

    private LocalDate purchaseDate;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal contractValue;

    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "contract")
    private List<Payment> payments;
}