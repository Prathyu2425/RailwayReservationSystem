package com.example.TrainReservation.exception;


@SuppressWarnings("serial")
public class TicketIdNotFoundException extends Exception {
	String message;
	public TicketIdNotFoundException(String str) {
		message = str; 
	}
	public TicketIdNotFoundException() {
}
	public String toString() {
		return ("An Exception Occured (Reservation MicroService): "+message);
	}
	
}
