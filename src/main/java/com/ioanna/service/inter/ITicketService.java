package com.ioanna.service.inter;

import java.util.List;

import com.ioanna.DAO.TicketResponseDAO;
import com.ioanna.DAO.TicketUserDAO;
import com.ioanna.DTO.TicketCheckInDTO;
import com.ioanna.entity.Ticket;

public interface ITicketService {
	
	TicketResponseDAO getTicketById(Long id);
	
	Ticket saveNewTicket(Ticket ticket);
	
	String deleteTicketById(Long id);
		
	TicketCheckInDTO checkInTicket(TicketCheckInDTO ticketDto);
	
	List<TicketUserDAO> getAllTickets(Long userId);
	
}
