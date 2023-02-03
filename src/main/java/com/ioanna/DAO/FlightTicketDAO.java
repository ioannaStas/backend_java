package com.ioanna.DAO;

import java.sql.Date;

public class FlightTicketDAO {

	private Long id;
	
	private String departurePlace;
	
	private String destination;
	
	private int arrivalTime;
	
	private Date flightDate;
	
	private int departureTime;
	
	private String flightNumber;
	
	private float price;

	public FlightTicketDAO(Long id, String departurePlace, String destination, int arrivalTime, Date flightDate,
			int departureTime, String flightNumber, float price) {
		super();
		this.id = id;
		this.departurePlace = departurePlace;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.flightDate = flightDate;
		this.departureTime = departureTime;
		this.flightNumber = flightNumber;
		this.price = price;
	}
	
	public FlightTicketDAO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeparturePlace() {
		return departurePlace;
	}

	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public int getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
