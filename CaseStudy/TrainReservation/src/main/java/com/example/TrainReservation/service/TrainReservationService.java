package com.example.TrainReservation.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrainReservation.controller.ReservationController;
import com.example.TrainReservation.exception.TicketIdNotFoundException;
import com.example.TrainReservation.model.Reservation;
import com.example.TrainReservation.repository.ReservationRepository;




@Service
public class TrainReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	Logger logger = LoggerFactory.getLogger(ReservationController.class); 

	
	

	public Reservation addPassenger (Reservation reservation) throws TicketIdNotFoundException, Exception{
		return reservationRepository.save(reservation);
	}

	public List<Reservation> getContact() throws TicketIdNotFoundException, Exception{
		List<Reservation> reservation = reservationRepository.findAll();
		System.out.println("Getting data from DB : " + reservation);
		if (reservation.isEmpty()) {
			throw new TicketIdNotFoundException("NO TICKETS EXISTS");
		}
			else
			{
			
		
		return reservation;
	}
			}
	/*
	 * public Optional<Reservation> getPassengerbyId(String id) { return
	 * reservationRepository.findById(id); }
	 */

	public void deletePassenger(Reservation reservation) throws TicketIdNotFoundException, Exception{
		reservationRepository.delete(reservation);
		//List<Reservation> findByPnr = null;
		//f(!findByPnr.isEmpty()) {
		
		//throw new TicketIdNotFoundException(" NO TICKETS EXISTS BY PNR");
		//}
		//else
		//{
		//return ;	
	
		}
}

