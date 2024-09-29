package com.ratingapplication.ratingservice.RatingService.controller;

import com.ratingapplication.ratingservice.RatingService.dto.RatingDto;
import com.ratingapplication.ratingservice.RatingService.entity.Rating;
import com.ratingapplication.ratingservice.RatingService.service.RatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> addRating(@Valid @RequestBody RatingDto ratingDto) {
        Rating savedRating = ratingService.addRating(ratingDto);
        return ResponseEntity.ok(savedRating);
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable String ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating) {
        Rating updatedRating = ratingService.updateRating(rating);
        return ResponseEntity.ok(updatedRating);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        List<Rating> ratings = ratingService.getRatingsByHotelId(hotelId);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        List<Rating> ratings = ratingService.getRatingsByUserId(userId);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Rating>> getRatingsByRatingGreaterThan(@PathVariable int rating) {
        List<Rating> ratings = ratingService.getRatingsByRatingGreaterThan(rating);
        return ResponseEntity.ok(ratings);
    }
}