package com.ioanna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ioanna.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	 
	@Query("SELECT f FROM Flight f WHERE f.id = :id")
	Flight getById(@Param("id") Long id);
	
	@Query("SELECT f FROM Flight f WHERE f.destination = :destination")
	Flight getByDestination(@Param("destination") String destination);
	
	@Query("SELECT f FROM Flight f WHERE f.destination = :toDestination AND f.departurePlace = :fromDeparture")
	List<Flight> getFlightsByAirports(@Param("fromDeparture") String fromDeparture, @Param("toDestination") String toDestination);
	
}
