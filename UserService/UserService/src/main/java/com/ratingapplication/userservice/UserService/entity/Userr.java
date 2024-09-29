package com.ratingapplication.userservice.UserService.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Userr {
    @Id
    @NotNull(message = "User Id cannot be null")
    private String userId;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;
    @NotNull(message = "Time cannot be null")
    private LocalDateTime createdAt;
}
