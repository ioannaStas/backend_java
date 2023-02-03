package com.ioanna.service.inter;

import java.util.List;

import com.ioanna.DAO.UserResponseDAO;
import com.ioanna.DAO.UserTicketDAO;
import com.ioanna.entity.User;

public interface IUserService {

	UserTicketDAO findById(Long id);
	
	List<UserTicketDAO> getAllUsers();
	
	UserResponseDAO getUserWithTicketsByUsername(String username);
	
	User saveNewUser(User user);
	
	String deleteUserById(Long id);
	
	UserTicketDAO getByCredentials(String username, String password);
}
