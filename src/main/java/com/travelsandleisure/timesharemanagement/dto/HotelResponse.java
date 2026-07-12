package com.travelsandleisure.timesharemanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelResponse {

    private Long hotelId;
    private String hotelName;
    private String city;
    private String state;
    private String country;
    private Integer totalRooms;
    private Boolean active;
}