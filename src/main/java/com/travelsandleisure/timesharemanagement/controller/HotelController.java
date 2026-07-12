package com.travelsandleisure.timesharemanagement.controller;

import com.travelsandleisure.timesharemanagement.dto.HotelRequest;
import com.travelsandleisure.timesharemanagement.dto.HotelResponse;
import com.travelsandleisure.timesharemanagement.service.HotelService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public HotelResponse createHotel(
            @RequestBody HotelRequest request) {

        return hotelService.createHotel(request);
    }

    @GetMapping
    public List<HotelResponse> getAllHotels() {

        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public HotelResponse getHotelById(
            @PathVariable Long id) {

        return hotelService.getHotelById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(
            @PathVariable Long id) {

        hotelService.deleteHotel(id);
    }
}
