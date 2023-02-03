package com.ioanna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ioanna.DAO.TicketResponseDAO;
import com.ioanna.DAO.TicketUserDAO;
import com.ioanna.DTO.TicketCheckInDTO;
import com.ioanna.entity.Ticket;
import com.ioanna.service.TicketServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	private TicketServiceImpl ticketService;
	
	@GetMapping("")
	@ResponseBody
	ResponseEntity<TicketResponseDAO> findById(@RequestParam(name="id") Long id){
		return new ResponseEntity<>(ticketService.getTicketById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	@ResponseBody
	ResponseEntity<List<TicketUserDAO>> getAllTickets(@RequestParam(name="userId") Long userId){
		return new ResponseEntity<>(ticketService.getAllTickets(userId),HttpStatus.OK);
	}
	
	@PostMapping("/ticket")
	ResponseEntity<Ticket> saveNewTicket(@RequestBody Ticket ticket){
		return new ResponseEntity<>(ticketService.saveNewTicket(ticket), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/ticket")
	ResponseEntity<String> deleteTicket(@RequestParam(name="id") Long id){
		return new ResponseEntity<>(ticketService.deleteTicketById(id), HttpStatus.OK);
	}
	
	@PostMapping("/checkin")
	ResponseEntity<TicketCheckInDTO> checkInTicket(@RequestBody TicketCheckInDTO ticketDto){
		TicketCheckInDTO ticketResponse = ticketService.checkInTicket(ticketDto);
		return new ResponseEntity<>(ticketResponse, HttpStatus.OK);
	}
	
}
