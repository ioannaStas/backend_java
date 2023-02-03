package com.ioanna.DAO;

public class TicketResponseDAO {

	private Long id;
			
	private String seat;
	
	private boolean checkedIn;
	
	private FlightTicketDAO flight;
	
	private UserTicketDAO user;

	public TicketResponseDAO(Long id, String barCode, float price, String seat, FlightTicketDAO flight,
			UserTicketDAO user, boolean checkedIn) {
		super();
		this.id = id;
		this.seat = seat;
		this.flight = flight;
		this.user = user;
		this.checkedIn = checkedIn;
	}
	
	public TicketResponseDAO() {
		
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

	public UserTicketDAO getUser() {
		return user;
	}

	public void setUser(UserTicketDAO user) {
		this.user = user;
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	
}
