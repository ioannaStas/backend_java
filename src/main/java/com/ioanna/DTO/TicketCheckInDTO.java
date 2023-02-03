package com.ioanna.DTO;

public class TicketCheckInDTO {

	private Long id;
	
	private boolean checkedIn;

	public TicketCheckInDTO(Long id, boolean checkedIn) {
		this.id = id;
		this.checkedIn = checkedIn;
	}
	
	public TicketCheckInDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	
}
