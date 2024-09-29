package com.ratingapplication.userservice.UserService.controller;

import com.ratingapplication.userservice.UserService.entity.Userr;
import com.ratingapplication.userservice.UserService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Userr> getUserById(@PathVariable String id) {
        Userr user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<Userr>> getAllUsers() {
        List<Userr> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<Userr> createUser( @RequestBody Userr user) {
        Userr savedUser = userService.saveUser(user);
        return ResponseEntity.status(201).body(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Userr> updateUser(@PathVariable String id,@RequestBody Userr user) {
        user.setUserId(id);
        user.setCreatedAt(LocalDateTime.now());
        Userr updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Userr> getUserByName(@PathVariable String name) {
        Userr user = userService.getUserByName(name);
        return ResponseEntity.ok(user);
    }
}