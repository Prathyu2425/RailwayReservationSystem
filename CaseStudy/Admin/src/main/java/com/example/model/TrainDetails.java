package com.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Details")
public class TrainDetails {
	    
	   
	private String id;
	private String trainName;
	private String depTime;
	private String origin;
	private String destination;
	private String fare;
	
	public TrainDetails() {
	
	}
	
	
	public TrainDetails(String id, String trainName, String depTime, String origin, String destination, String fare) {
		super();
		this.id = id;
		this.trainName = trainName;
		this.depTime = depTime;
		this.origin = origin;
		this.destination = destination;
		this.fare = fare;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "TrainDetails [id=" + id + ", trainName=" + trainName + ", depTime=" + depTime + ", origin=" + origin
				+ ", destination=" + destination + ", fare=" + fare + "]";
	}
	
	
	
	
	

}
