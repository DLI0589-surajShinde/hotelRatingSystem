package com.ratingapplication.hotelservice.HotelService.service;

import com.ratingapplication.hotelservice.HotelService.entity.Hotel;
import com.ratingapplication.hotelservice.HotelService.exception.HotelNotFoundException;
import com.ratingapplication.hotelservice.HotelService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public Hotel getHotelById(String hotelId){
        return hotelRepository.findById(hotelId).orElseThrow(()->new HotelNotFoundException("Hotel not found with id: "+hotelId));
    }

    public Hotel getHotelByName(String hotelName){
        return Optional.ofNullable(hotelRepository.findByName(hotelName)).orElseThrow(()->new HotelNotFoundException("Hotel not found with name: "+hotelName));
    }

    public Hotel addHotel(Hotel hotel){
        hotel.setHotelId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(String hotelId){
        hotelRepository.deleteById(hotelId);
    }

    public Hotel updateHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public void deleteAllHotels(){
        hotelRepository.deleteAll();
    }

    public long getHotelCount(){
        return hotelRepository.count();
    }

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }
}
