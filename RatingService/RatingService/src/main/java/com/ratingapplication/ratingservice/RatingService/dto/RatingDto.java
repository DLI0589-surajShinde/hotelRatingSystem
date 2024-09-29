package com.ratingapplication.ratingservice.RatingService.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RatingDto {

    private String hotelId;
    private String userId;
    @Max(value = 5, message = "Rating should be less than or equal to 5")
    private int rating;
    private String review;
}
