package com.ioanna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ioanna.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	@Query("SELECT t from Ticket t WHERE t.id = :id")
	Ticket getById(@Param("id") Long id);
	
	@Modifying
	@Query("UPDATE Ticket t SET t.checkedIn = :checked WHERE t.id = :id")
	void updateCheckIn(@Param("checked") boolean checked, @Param("id") Long id);
	
	@Query("SELECT t FROM Ticket t WHERE t.user.id = :userId")
	List<Ticket> getAllTickets(@Param("userId") Long id);
}
