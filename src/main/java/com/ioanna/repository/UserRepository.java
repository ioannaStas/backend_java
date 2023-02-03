package com.ioanna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ioanna.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.id = :id")
	User getById(@Param("id") Long id);
	
	@Query("SELECT u FROM User u order by u.userName desc")
	List<User> getAllUsers();
	
	@Query("SELECT u FROM User u WHERE u.userName = :username")
	User getByUsername(@Param("username") String userName);
	
	@Query ("SELECT u FROM User u WHERE (u.userName = :userName AND u.password = :passWord)")
	User getByLogin(@Param("userName") String userName,@Param("passWord") String passWord);

}
