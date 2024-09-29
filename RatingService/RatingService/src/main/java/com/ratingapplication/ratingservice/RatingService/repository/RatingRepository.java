package com.ratingapplication.ratingservice.RatingService.repository;

import com.ratingapplication.ratingservice.RatingService.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {
    List<Rating> findByHotelId(String hotelId);
    List<Rating> findByUserId(String userId);
    List<Rating> findByRatingGreaterThan(int rating);
}
