package com.ratingapplication.hotelservice.HotelService.controller;

import com.ratingapplication.hotelservice.HotelService.entity.Hotel;
import com.ratingapplication.hotelservice.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.addHotel(hotel);
        return ResponseEntity.ok(savedHotel);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/name/{hotelName}")
    public ResponseEntity<Hotel> getHotelByName(@PathVariable String hotelName) {
        Hotel hotel = hotelService.getHotelByName(hotelName);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable String hotelId) {
        hotelService.deleteHotel(hotelId);
        return ResponseEntity.ok().build();
    }
}