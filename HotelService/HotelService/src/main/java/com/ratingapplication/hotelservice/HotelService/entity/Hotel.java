package com.ratingapplication.hotelservice.HotelService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {
    @Id
    @NotNull(message = "HotelId cannot be null")
    private String hotelId;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Address cannot be null")
    private String address;
}
