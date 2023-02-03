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
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username", length=50, nullable=false)
	private String userName;
	
	@Column(name="name", length=100, nullable=false)
	private String name;
	
	@Column(name="passwrd", length=50, nullable=false)
	private String password;
	
	@Column(name="surname", length=200, nullable=false)
	private String surName;
	
	@Column(name="birthdate", nullable=false)
	private Date birthDay;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets = new ArrayList<>();
	
	public User(Long id, String userName, String name, String surName, Date birthDay) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.surName = surName;
		this.birthDay = birthDay;
	}
	
	public User() {
		
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
	
	public List<Ticket> getTickets() {
		return tickets;
	}
		
}
