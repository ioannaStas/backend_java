package com.ioanna.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="seat", length=5, nullable=false)
	private String seat;
	
	@Column(name="checked_in")
	private boolean checkedIn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="flightID", nullable=false)
	private Flight flight;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userID", nullable=false)
	private User user;

	public Ticket(Long id, float price, String seat, Flight flight, User user, boolean checked) {
		super();
		this.id = id;
		this.seat = seat;
		this.flight = flight;
		this.user = user;
		this.checkedIn = checked;
	}

	public Ticket() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

}
