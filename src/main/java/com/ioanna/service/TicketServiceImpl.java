package com.ioanna.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ioanna.DAO.FlightTicketDAO;
import com.ioanna.DAO.TicketResponseDAO;
import com.ioanna.DAO.TicketUserDAO;
import com.ioanna.DAO.UserTicketDAO;
import com.ioanna.DTO.TicketCheckInDTO;
import com.ioanna.entity.Ticket;
import com.ioanna.repository.TicketRepository;
import com.ioanna.service.inter.ITicketService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TicketServiceImpl implements ITicketService{
	
	@Autowired
	TicketRepository ticketRepo;

	public TicketResponseDAO getTicketById(Long id) {
		Ticket ticket = ticketRepo.getById(id);
		TicketResponseDAO ticketDao = new TicketResponseDAO();
		ticketDao.setId(ticket.getId());
		ticketDao.setSeat(ticket.getSeat());
		ticketDao.setFlight(new FlightTicketDAO(ticket.getFlight().getId(), ticket.getFlight().getDeparturePlace(),
				ticket.getFlight().getDestination(), ticket.getFlight().getArrivalTime(), ticket.getFlight().getFlightDate(),
				ticket.getFlight().getDepartureTime(), ticket.getFlight().getFlightNumber(), ticket.getFlight().getPrice()));
		ticketDao.setUser(new UserTicketDAO(ticket.getUser().getId(), ticket.getUser().getUserName(), ticket.getUser().getName(), ticket.getUser().getSurName(),
				ticket.getUser().getBirthDay()));
		ticketDao.setCheckedIn(ticket.isCheckedIn());
		return ticketDao;
	}
	
	public Ticket saveNewTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}
	
	public String deleteTicketById(Long id) {
		String responseMessage = "";
		try {
			ticketRepo.deleteById(id);
			responseMessage = "Ticket deleted";
		} catch(Exception e) {
			responseMessage = e.getMessage();
		}
		return responseMessage;
	}
	
	public TicketCheckInDTO checkInTicket(TicketCheckInDTO ticketDto) {
		ticketRepo.updateCheckIn(ticketDto.isCheckedIn(), ticketDto.getId());
		return ticketDto;
	}
	
	public List<TicketUserDAO> getAllTickets(Long userId){
		List<Ticket> ticketList = new ArrayList<>();
		ticketList = ticketRepo.getAllTickets(userId);
		List<TicketUserDAO> daoList = new ArrayList<>();
		for(Ticket ticket: ticketList) {
			TicketUserDAO dao = new TicketUserDAO();
			dao.setId(ticket.getId());
			dao.setSeat(ticket.getSeat());
			dao.setCheckedIn(ticket.isCheckedIn());
			FlightTicketDAO flightDao = new FlightTicketDAO();
			flightDao.setId(ticket.getFlight().getId());
			flightDao.setDeparturePlace(ticket.getFlight().getDeparturePlace());
			flightDao.setDestination(ticket.getFlight().getDestination());
			flightDao.setArrivalTime(ticket.getFlight().getArrivalTime());
			flightDao.setFlightDate(ticket.getFlight().getFlightDate());
			flightDao.setDepartureTime(ticket.getFlight().getDepartureTime());
			flightDao.setFlightNumber(ticket.getFlight().getFlightNumber());
			flightDao.setPrice(ticket.getFlight().getPrice());
			dao.setFlight(flightDao);
			daoList.add(dao);
		}
		return daoList;
	}

}
