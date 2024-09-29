package com.ratingapplication.hotelservice.HotelService.exception;



public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String message) {
        super(message);
    }
}
