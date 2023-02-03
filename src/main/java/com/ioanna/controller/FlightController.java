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

import com.ioanna.DAO.FlightResponseDAO;
import com.ioanna.DAO.FlightTicketDAO;
import com.ioanna.entity.Flight;
import com.ioanna.service.FlightServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	private FlightServiceImpl flightService;
	
	@GetMapping("")
	@ResponseBody
	ResponseEntity<FlightResponseDAO> findById(@RequestParam(name="id") Long id){
		FlightResponseDAO flight = flightService.getFlightById(id);
		return new ResponseEntity<>(flight,HttpStatus.OK);
	}
	
	@GetMapping("/destination")
	@ResponseBody
	ResponseEntity<FlightTicketDAO> findByDestination(@RequestParam(name="destination") String destination){
		FlightTicketDAO flight = flightService.findByDestination(destination);
		return new ResponseEntity<>(flight,HttpStatus.OK);
	}

	@PostMapping("/flight")
	ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
		return new ResponseEntity<>(flightService.saveNewFlight(flight), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/flight")
	ResponseEntity<String> deleteFlight(@RequestParam(name="id") Long id){
		return new ResponseEntity<>(flightService.deleteFlightById(id), HttpStatus.OK);
	}
	
	@GetMapping("/getByAirports")
	@ResponseBody
	ResponseEntity<List<FlightTicketDAO>> getFlightsByAirports(@RequestParam(name="fromDeparture") String fromDeparture,
			@RequestParam(name="toDestination") String toDestination){
		List<FlightTicketDAO> flights = flightService.getFlightsByAirports(fromDeparture, toDestination);
		return new ResponseEntity<>(flights,HttpStatus.OK);
	}
}
