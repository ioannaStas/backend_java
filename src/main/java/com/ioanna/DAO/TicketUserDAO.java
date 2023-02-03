package com.ioanna.DAO;

public class TicketUserDAO {

	private Long id;
			
	private String seat;
	
	private FlightTicketDAO flight;
	
	private boolean checkedIn;

	public TicketUserDAO(Long id, String seat, FlightTicketDAO flight, boolean checkedIn) {
		super();
		this.id = id;
		this.seat = seat;
		this.flight = flight;
		this.checkedIn = checkedIn;
	}
	
	public TicketUserDAO() {
		
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

	public FlightTicketDAO getFlight() {
		return flight;
	}

	public void setFlight(FlightTicketDAO flight) {
		this.flight = flight;
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	
}
