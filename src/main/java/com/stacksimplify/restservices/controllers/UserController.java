/**
 * 
 */
package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;

/**
 * @author Avi
 * Get all Users from H2 Database
 * Create New user using Postman by sending request body in a json format
 */
// Controller 

@RestController
public class UserController {

	// Autowired User
	@Autowired
	private UserService userService;
	
	//getAllUsers method
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	//getUserById method
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id){
		try {
			return userService.getUserById(id);
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage()); 
		}
	}
	
	// Create User method
	//@RequestBody Annotation within method
	//@PostMapping Annotation
	// Use UriComponentsBuilder to return location header as user PATH
	@PostMapping("/users")
	public ResponseEntity<String> createUser(@RequestBody User user, UriComponentsBuilder builder) {
		try {
			userService.createUser(user);	
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
			
		}catch(UserExistsException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage()); 
		}

	}
	
	//updateUserById
	//use @PutMapping annotation for updating existing user object
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		try{
			return userService.updateUserById(id, user);
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage()); 
		}
	}

	
	//deleteUserById
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Long id){
		userService.deleteUserById(id);
	}
	
	//getUserByUsername
	@GetMapping("/users/byusername/{username}")
	public User getUserByUsername(@PathVariable("username") String username){
		return userService.getUserByUsername(username);
	}
}
