package com.ioanna.service.inter;

import java.util.List;

import com.ioanna.DAO.FlightResponseDAO;
import com.ioanna.DAO.FlightTicketDAO;
import com.ioanna.entity.Flight;

public interface IFlightService {
	
	FlightResponseDAO getFlightById(Long id);

	Flight saveNewFlight(Flight flight);
	
	String deleteFlightById(Long id);
	
	FlightTicketDAO findByDestination(String destination);
	
	List<FlightTicketDAO> getFlightsByAirports(String fromDeparture, String toDestination);
	
}
