/**
 * 
 */
package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;

/**
 * @author Avi
 *
 */
@RestController
@Validated
@RequestMapping(value = "/hateoas/users")  // import org.springframework.web.bind.annotation.RequestMapping package
public class UserHateoasController {

	// Autowired UserService
	@Autowired
	private UserService userService;
	
	//getAllUsers method
	// @GetMapping("/users"); Earlier I have not defined @RequestMapping at class level so, I had to put URL for each method; now it is not needed
	@GetMapping
	public CollectionModel<User> getAllUsers() throws UserNotFoundException{
//		return userService.getAllUsers();
		List<User> allusers = userService.getAllUsers();
		
		for (User user : allusers) {
			//Self Link
			long userid = user.getUserid(); // We need variable to do self linking while calling slash method
			Link selflink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
			user.add(selflink);	
			
			//Relationship link with getallOrders() API call
			CollectionModel<Order> orders = WebMvcLinkBuilder.methodOn(OrderHateoasController.class).getAllorders(userid);
			Link orderslink = WebMvcLinkBuilder.linkTo(orders).withRel("all-orders");
			user.add(orderslink);
		}
		
		Link link = WebMvcLinkBuilder.linkTo(this.getClass()).withSelfRel();
		CollectionModel<User> finalusers = new CollectionModel<User>(allusers, link);
		//CollectionModel
		return finalusers; // Resource object is replaced by EntityModel object in HATEOAS new version
	}
	
	//getUserById method
	@GetMapping("/{id}")
	public EntityModel<User> getUserById(@PathVariable("id") @Min(1) Long id){
		try {
			Optional<User> userOptional = userService.getUserById(id);
			User user = userOptional.get();
			long userid = user.getUserid(); // We need variable to do self linking while calling slash method
			Link selflink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
			user.add(selflink);
			
			EntityModel<User> finalResource = new EntityModel<User>(user);
			return finalResource; // Resource object is replaced by EntityModel object in HATEOAS new version
			
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage()); 
		}
	}
	
//	TO DO: Add all other methods that we have in UserController
	
}
