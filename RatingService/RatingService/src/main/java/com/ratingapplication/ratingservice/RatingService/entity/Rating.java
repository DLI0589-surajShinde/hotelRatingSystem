package com.ratingapplication.ratingservice.RatingService.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

    @Id
    @NotNull(message = "RatingId cannot be null")
    private String ratingId;

    @NotNull(message = "HotelId cannot be null")
    private String hotelId;

    @NotNull(message = "UserId cannot be null")
    private String userId;
    @NotNull(message = "Rating cannot be null")
    @Max(value = 5, message = "Rating should be less than or equal to 5")
    private int rating;

    @NotNull(message = "Review cannot be null")
    @Size(min = 10, message = "Review should have atleast 10 characters")
    private String review;

    @NotNull(message = "CreatedOn cannot be null")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdOn = LocalDateTime.now();
}
