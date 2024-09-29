package com.ratingapplication.userservice.UserService.service;


import com.ratingapplication.userservice.UserService.entity.Userr;
import com.ratingapplication.userservice.UserService.exception.UserNotFoundException;
import com.ratingapplication.userservice.UserService.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Userr getUserById(String userId){
        return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found with id:"+userId));
    }

    public Userr saveUser(Userr user){
        user.setUserId(UUID.randomUUID().toString());
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }

    public Userr updateUser(Userr user){
        return userRepository.save(user);
    }

    public Userr getUserByName(String name){
        return Optional.ofNullable(userRepository.findByName(name)).orElseThrow(()-> new UserNotFoundException("User not found with name:"+name));
    }

    public List<Userr> getAllUsers(){
        return userRepository.findAll();
    }
}
