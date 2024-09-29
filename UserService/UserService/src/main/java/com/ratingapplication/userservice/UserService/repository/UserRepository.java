package com.ratingapplication.userservice.UserService.repository;

import com.ratingapplication.userservice.UserService.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Userr,String> {

    //findByName  create this method
    Userr findByName(String name);  // what it teturn if user is not found

}
