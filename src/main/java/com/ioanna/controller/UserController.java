package com.ioanna.controller;

import java.util.ArrayList;
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

import com.ioanna.DAO.UserResponseDAO;
import com.ioanna.DAO.UserTicketDAO;
import com.ioanna.entity.User;
import com.ioanna.service.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("")
	@ResponseBody
	ResponseEntity<UserTicketDAO> findById(@RequestParam(name="id") Long id){
		UserTicketDAO user = userService.findById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	@ResponseBody
	ResponseEntity<List<UserTicketDAO>> getAllUsers(){
		List<UserTicketDAO> listUsers = new ArrayList<>();
		listUsers = userService.getAllUsers();
		return new ResponseEntity<>(listUsers,HttpStatus.OK);
	}
	
	@GetMapping("/tickets")
	@ResponseBody
	ResponseEntity<UserResponseDAO> getUserWithTicketsByUsername(@RequestParam(name="username") String username){
		UserResponseDAO user = userService.getUserWithTicketsByUsername(username);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/login")
	@ResponseBody
	ResponseEntity<UserTicketDAO> getByCredentials(@RequestParam(name="username") String username,@RequestParam(name="password") String password ){
		UserTicketDAO user = userService.getByCredentials(username,password);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PostMapping("/user")
	ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<>(userService.saveNewUser(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user")
	ResponseEntity<String> deleteUser(@RequestParam(name="id") Long id){
		return new ResponseEntity<>(userService.deleteUserById(id), HttpStatus.OK);
	}
	
}
