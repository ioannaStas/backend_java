package com.ioanna.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ioanna.DAO.FlightTicketDAO;
import com.ioanna.DAO.TicketUserDAO;
import com.ioanna.DAO.UserResponseDAO;
import com.ioanna.DAO.UserTicketDAO;
import com.ioanna.entity.User;
import com.ioanna.repository.UserRepository;
import com.ioanna.service.inter.IUserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	protected UserRepository userRepo;

	@Override
	public UserTicketDAO findById(Long id) {
		User user = userRepo.getById(id);
		return new UserTicketDAO(user.getId(), user.getUserName(), user.getName(), user.getSurName(), user.getBirthDay());
	}
	
	@Override
	public List<UserTicketDAO> getAllUsers(){
		List<User> userList = new ArrayList<>();
		List<UserTicketDAO> userDaoList = new ArrayList<>();
		userList = userRepo.getAllUsers();
		for(int i=0; i<userList.size(); i++) {
			userDaoList.add(new UserTicketDAO(userList.get(i).getId(), userList.get(i).getUserName(), userList.get(i).getName(), 
					userList.get(i).getSurName(), userList.get(i).getBirthDay()));
		}
		return userDaoList;
	}
	
	public UserResponseDAO getUserWithTicketsByUsername(String username) {
		User user = userRepo.getByUsername(username);
		List<TicketUserDAO> ticketList = new ArrayList<>();
		for(int i=0; i<user.getTickets().size(); i++) {
			FlightTicketDAO flightDao = new FlightTicketDAO();
			flightDao.setId(user.getTickets().get(i).getFlight().getId());
			flightDao.setArrivalTime(user.getTickets().get(i).getFlight().getArrivalTime());
			flightDao.setFlightNumber(user.getTickets().get(i).getFlight().getFlightNumber());
			flightDao.setDeparturePlace(user.getTickets().get(i).getFlight().getDeparturePlace());
			flightDao.setDestination(user.getTickets().get(i).getFlight().getDestination());
			flightDao.setFlightDate(user.getTickets().get(i).getFlight().getFlightDate());
			flightDao.setDepartureTime(user.getTickets().get(i).getFlight().getDepartureTime());
			ticketList.add(new TicketUserDAO(user.getTickets().get(i).getId(),
					user.getTickets().get(i).getSeat(), flightDao, user.getTickets().get(i).isCheckedIn()));
		}
		return new UserResponseDAO(user.getId(), user.getUserName(), user.getName(), user.getSurName(), user.getBirthDay(), ticketList);
	}
	
	public User saveNewUser(User user) {
		return userRepo.save(user);
	}
	
	public String deleteUserById(Long id) {
		String responseMessage = "";
		try {
			userRepo.deleteById(id);
			responseMessage = "User deleted";
		} catch(Exception e) {
			responseMessage = e.getMessage();
		}
		return responseMessage;
	}
	
	public UserTicketDAO getByCredentials(String username, String password) {
		User user = userRepo.getByLogin(username, password);
		return new UserTicketDAO(user.getId(), user.getUserName(), user.getName(), user.getSurName(), user.getBirthDay());	
	}
	
}
