package com.ioanna.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="flights")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="departure_place", length=40, nullable=false)
	private String departurePlace;
	
	@Column(name="destination", length=40, nullable=false)
	private String destination;
	
	@Column(name="arrival_time", nullable=false)
	private int arrivalTime;
	
	@Column(name="flight_date", nullable=false)
	private Date flightDate;
	
	@Column(name="departure_time", nullable=false)
	private int departureTime;
	
	@Column(name="price", nullable=false)
	private float price;
	
	@Column(name="flight_number", length=5, nullable=false)
	private String flightNumber;
	
	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets = new ArrayList<>();

	public Flight(Long id, String departurePlace, String destination, int arrivalTime, Date flightDate,
			int departureTime, String flightNumber, float price) {
		super();
		this.id = id;
		this.departurePlace = departurePlace;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.flightDate = flightDate;
		this.flightNumber = flightNumber;
		this.departureTime = departureTime;
		this.price = price;
	}
	
	public Flight() {
		
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
}
