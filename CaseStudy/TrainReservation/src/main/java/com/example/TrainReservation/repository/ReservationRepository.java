package com.example.TrainReservation.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.TrainReservation.model.Reservation;
import com.google.common.base.Optional;

public interface ReservationRepository extends MongoRepository<Reservation, String> {

List<Reservation> deleteByPnr(long pnr);
	
	@Query("{ 'pnr': ?0 }")
	List<Reservation> findByPnr(long pnr);

	

	

	
	
	

	
	

}	
	
	
	


