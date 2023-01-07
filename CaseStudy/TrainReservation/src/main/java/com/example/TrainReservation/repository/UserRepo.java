package com.example.TrainReservation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.TrainReservation.model.User1;


public interface UserRepo extends MongoRepository<User1, String> {

	User1 findByUsername(String username);

}
