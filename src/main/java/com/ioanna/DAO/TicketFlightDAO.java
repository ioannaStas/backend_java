package com.ioanna.DAO;

public class TicketFlightDAO {

	private Long id;

	private String seat;
	
	private boolean checkedIn;

	private UserTicketDAO user;

	public TicketFlightDAO(Long id, String seat, boolean checkedIn, UserTicketDAO user) {
		super();
		this.id = id;
		this.checkedIn = checkedIn;
		this.seat = seat;
		this.user = user;
	}

	public TicketFlightDAO() {
		
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
