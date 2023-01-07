package com.example.TrainDetails.exception;


//@SuppressWarnings("serial")
public class TrainIdNotFoundException extends Exception{
	
	
	
	private String message;
	
	
	
	public TrainIdNotFoundException() {
}
	public TrainIdNotFoundException(String message) {
		super(message);
		this.message = message;
	}
}	

