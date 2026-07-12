package com.travelsandleisure.timesharemanagement.service;

import com.travelsandleisure.timesharemanagement.dto.HotelRequest;
import com.travelsandleisure.timesharemanagement.dto.HotelResponse;

import java.util.List;

public interface HotelService {

    HotelResponse createHotel(HotelRequest request);

    List<HotelResponse> getAllHotels();

    HotelResponse getHotelById(Long id);

    void deleteHotel(Long id);
}