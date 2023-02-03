package com.ioanna.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ioanna.DAO.FlightResponseDAO;
import com.ioanna.DAO.FlightTicketDAO;
import com.ioanna.DAO.TicketFlightDAO;
import com.ioanna.DAO.UserTicketDAO;
import com.ioanna.entity.Flight;
import com.ioanna.repository.FlightRepository;
import com.ioanna.service.inter.IFlightService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements IFlightService{

	@Autowired
	protected FlightRepository flightRepo;
	
	@Override
	public FlightResponseDAO getFlightById(Long id) {
		Flight flight = flightRepo.getById(id);
		FlightResponseDAO flightDao = new FlightResponseDAO();
		flightDao.setId(flight.getId());
		flightDao.setFlightNumber(flight.getFlightNumber());
		flightDao.setArrivalTime(flight.getArrivalTime());
		flightDao.setDestination(flight.getDestination());
		flightDao.setDeparturePlace(flight.getDeparturePlace());
		flightDao.setDepartureTime(flight.getDepartureTime());
		flightDao.setFlightDate(flight.getFlightDate());
		for(int i=0; i<flight.getTickets().size(); i++) {
			UserTicketDAO user = new UserTicketDAO(flight.getTickets().get(i).getUser().getId(), flight.getTickets().get(i).getUser().getUserName(),
					flight.getTickets().get(i).getUser().getName(),flight.getTickets().get(i).getUser().getSurName(), flight.getTickets().get(i).getUser().getBirthDay());
			TicketFlightDAO ticket = new TicketFlightDAO(flight.getTickets().get(i).getId(), flight.getTickets().get(i).getSeat(), flight.getTickets().get(i).isCheckedIn(), user);
			flightDao.getTickets().add(ticket);
		}
		return flightDao;
	}
	
	public Flight saveNewFlight(Flight flight) {
		return flightRepo.save(flight);
	}
	
	public String deleteFlightById(Long id) {
		String responseMessage = "";
		try {
			flightRepo.deleteById(id);
			responseMessage = "Flight deleted";
		} catch(Exception e) {
			responseMessage = e.getMessage();
		}
		return responseMessage;
	}
	
	public FlightTicketDAO findByDestination(String destination) {
		Flight flight = flightRepo.getByDestination(destination);
		FlightTicketDAO flightDao = new FlightTicketDAO();
		flightDao.setId(flight.getId());
		flightDao.setFlightNumber(flight.getFlightNumber());
		flightDao.setArrivalTime(flight.getArrivalTime());
		flightDao.setDestination(flight.getDestination());
		flightDao.setDeparturePlace(flight.getDeparturePlace());
		flightDao.setDepartureTime(flight.getDepartureTime());
		flightDao.setFlightDate(flight.getFlightDate());
		return flightDao;
	}
	
	public List<FlightTicketDAO> getFlightsByAirports(String fromDeparture, String toDestination) {
		List<Flight> flights = flightRepo.getFlightsByAirports(fromDeparture, toDestination);
		List<FlightTicketDAO> flightsList = new ArrayList<>();
		for(Flight flight: flights) {
			FlightTicketDAO flightDao = new FlightTicketDAO(flight.getId(), flight.getDeparturePlace(), flight.getDestination(),
					flight.getArrivalTime(), flight.getFlightDate(), flight.getDepartureTime(), flight.getFlightNumber(), flight.getPrice());
			flightsList.add(flightDao);
		}
		return flightsList;
	}
	

}
