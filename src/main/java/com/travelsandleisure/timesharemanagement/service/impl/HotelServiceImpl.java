package com.travelsandleisure.timesharemanagement.service.impl;

import com.travelsandleisure.timesharemanagement.dto.HotelRequest;
import com.travelsandleisure.timesharemanagement.dto.HotelResponse;
import com.travelsandleisure.timesharemanagement.entity.Hotel;
import com.travelsandleisure.timesharemanagement.exception.HotelNotFoundException;
import com.travelsandleisure.timesharemanagement.repository.HotelRepository;
import com.travelsandleisure.timesharemanagement.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public HotelResponse createHotel(HotelRequest request) {

        Hotel hotel = new Hotel();

        hotel.setHotelName(request.getHotelName());
        hotel.setCity(request.getCity());
        hotel.setState(request.getState());
        hotel.setCountry(request.getCountry());
        hotel.setTotalRooms(request.getTotalRooms());
        hotel.setActive(request.getActive());

        Hotel savedHotel = hotelRepository.save(hotel);

        return mapToResponse(savedHotel);
    }

    @Override
    public List<HotelResponse> getAllHotels() {

        return hotelRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public HotelResponse getHotelById(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() ->
                        new HotelNotFoundException("Hotel not found with id " + id));

        return mapToResponse(hotel);
    }

    @Override
    public void deleteHotel(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() ->
                        new HotelNotFoundException("Hotel not found with id " + id));

        hotelRepository.delete(hotel);
    }

    private HotelResponse mapToResponse(Hotel hotel) {

        return HotelResponse.builder()
                .hotelId(hotel.getHotelId())
                .hotelName(hotel.getHotelName())
                .city(hotel.getCity())
                .state(hotel.getState())
                .country(hotel.getCountry())
                .totalRooms(hotel.getTotalRooms())
                .active(hotel.getActive())
                .build();
    }
}