package com.ratingapplication.ratingservice.RatingService.service;

import com.ratingapplication.ratingservice.RatingService.dto.RatingDto;
import com.ratingapplication.ratingservice.RatingService.entity.Rating;
import com.ratingapplication.ratingservice.RatingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;


    public Rating addRating(RatingDto ratingDto){
        Rating rating = new Rating();
        rating.setHotelId(ratingDto.getHotelId());
        rating.setUserId(ratingDto.getUserId());
        rating.setRating(ratingDto.getRating());
        rating.setReview(ratingDto.getReview());
        rating.setRatingId(UUID.randomUUID().toString());
        return ratingRepository.save(rating);
    }

    public void deleteRating(String ratingId){
        ratingRepository.deleteById(ratingId);
    }

    public Rating updateRating(Rating rating){
        return ratingRepository.save(rating);
    }

    public List<Rating> getAllRatings(){
        return ratingRepository.findAll();
    }

    public List<Rating> getRatingsByHotelId(String hotelId){
        return ratingRepository.findByHotelId(hotelId);
    }

    public List<Rating> getRatingsByUserId(String userId){
        return ratingRepository.findByUserId(userId);
    }

    public List<Rating> getRatingsByRatingGreaterThan(int rating){
        return ratingRepository.findByRatingGreaterThan(rating);
    }
}
