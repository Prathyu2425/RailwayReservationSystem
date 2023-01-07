package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.TrainDetails;


@Repository
public interface TrainRepository extends MongoRepository<TrainDetails, String> {

	@Query("{ origin: ?0},{destination: ?1")
	List<TrainDetails> findBySort(String origin, String destination);

	

}

