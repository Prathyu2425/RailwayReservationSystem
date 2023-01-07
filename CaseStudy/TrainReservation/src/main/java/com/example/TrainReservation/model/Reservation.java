package com.example.TrainReservation.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data

@Document(collection="Data")
public class Reservation {
	@Id
	public String id;
	
	public String name;
	
	public String sex;
	
	public String age;
	
	public String address;
	
	private String bank;
	
	private String className;
	
	private String Seats;
	
	private String origin;
	
	private String destination;
	
	private LocalDate date;
	
	private Long pnr;

	
public Reservation() {
		
	}

	

	public Reservation(String id, String name, String sex, String age, String address, String bank, String className,
			String Seats, String origin, String destination, LocalDate date, long Pnr) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.bank = bank;
		this.className = className;
		this.Seats = Seats;
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.pnr = pnr;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name; 
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSeats() {
		return Seats;
	}

	public void setSeats(String seats) {
		Seats = seats;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public long getpnr() {
		return pnr;
	}

	public void setpnr(long pnr) {
		pnr = pnr;
	}
	public void setPnr() {
		long number=(long) Math.floor(Math.random() * 3_000_000_00L)+2_000_000_00L;
		this.pnr = number;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", address=" + address
				+ ", bank=" + bank + ", className=" + className + ", Seats=" + Seats + ", origin=" + origin
				+ ", destination=" + destination + ", date=" + date + ", pnr=" + pnr + "]";
	}

	
	
	
	
	

	
	
	
	
	
		
		
		
		
		
		
	
	
	



}