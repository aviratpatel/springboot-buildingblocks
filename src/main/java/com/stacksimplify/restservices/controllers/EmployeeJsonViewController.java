/**
 * 
 */
package com.stacksimplify.restservices.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;
import com.stacksimplify.restservices.entities.Employee;
import com.stacksimplify.restservices.entities.Views;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.EmployeeService;

/**
 * @author Avi
 * Get all Users from H2 Database
 * Once you start the application, it creates H2 database(In Memory Database)
 * It also creates a table user and run data.sql file available under src/main/resources folder
 * 
 * Create New user using Postman by sending request body in a json format
 */
// Controller 

@RestController
@Validated
@RequestMapping(value = "/jsonview/employees")  // import org.springframework.web.bind.annotation.RequestMapping package
public class EmployeeJsonViewController {

	// Autowire UserService
	@Autowired
	private EmployeeService employeeService;
	
	
	//getUserById method
	@GetMapping("/empview/{id}")
	@JsonView(Views.EmployeeNormal.class)
	public Optional<Employee> getUserByIdEmplyeeeNormal(@PathVariable("id") @Min(1) Long id){
		try {
			return employeeService.getUserById(id);
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage()); 
		}
	}
	
	@GetMapping("/managerview/{id}")
	@JsonView(Views.Manager.class)
	public Optional<Employee> getUserByIdManagerView(@PathVariable("id") @Min(1) Long id){
		try {
			return employeeService.getUserById(id);
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage()); 
		}
	}
	
	
	@GetMapping("/hrview/{id}")
	@JsonView(Views.HR.class)
	public Optional<Employee> getUserByIdHRView(@PathVariable("id") @Min(1) Long id){
		try {
			return employeeService.getUserById(id);
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage()); 
		}
	}
}

