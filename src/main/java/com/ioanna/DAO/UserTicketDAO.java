package com.ioanna.DAO;

import java.sql.Date;

public class UserTicketDAO {

	private Long id;
	
	private String userName;
	
	private String name;
	
	private String surName;
	
	private Date birthDay;
	
	public UserTicketDAO(Long id, String userName, String name, String surName, Date birthDay) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.surName = surName;
		this.birthDay = birthDay;
	}
	
	public UserTicketDAO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
}
