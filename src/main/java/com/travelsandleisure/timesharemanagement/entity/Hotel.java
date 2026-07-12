package com.travelsandleisure.timesharemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    private String hotelName;

    private String city;

    private String state;

    private String country;

    private Integer totalRooms;

    private Boolean active;

    @OneToMany(mappedBy = "hotel")
    private List<TimeshareContract> contracts;
}