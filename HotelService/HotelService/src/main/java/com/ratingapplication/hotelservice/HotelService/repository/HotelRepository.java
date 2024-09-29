package com.ratingapplication.hotelservice.HotelService.repository;

import com.ratingapplication.hotelservice.HotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepository extends JpaRepository<Hotel,String > {
    Hotel findByName(String hotelName);
}
