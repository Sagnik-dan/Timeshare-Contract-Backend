package com.travelsandleisure.timesharemanagement.dto;

import lombok.Data;

@Data
public class HotelRequest {

    private String hotelName;
    private String city;
    private String state;
    private String country;
    private Integer totalRooms;
    private Boolean active;
}