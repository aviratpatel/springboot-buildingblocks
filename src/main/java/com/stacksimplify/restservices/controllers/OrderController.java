/**
 * 
 */
package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.Order;
//import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;

import com.stacksimplify.restservices.services.OrderService;
//import com.stacksimplify.restservices.services.UserService;

/**
 * @author Avi
 *
 */
@RestController
@RequestMapping(value="/users")
public class OrderController {
	

	// Autowired Order
	@Autowired
	private OrderService orderService;


/*
 *  As per tutorial in step 54, tutor did not create Order service layer and hence below code is old; 
 *  I created Order service on 7th June 2020 to provide 404 http status error when user or order is not found
 *  Reference: https://wipro.udemy.com/course/master-restful-apis-with-spring-boot/learn/lecture/15778092#overview
 *   
 	@GetMapping("/{userid}/orders")
	public List<Order> getAllorders(@PathVariable Long userid) throws UserNotFoundException{
		
		Optional<User> userOptional = userRepository.findById(userid);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User is not found; please check your input parameter");
		}
		
		return userOptional.get().getOrders();
	}
	
	
	// Add @RequestBody parameter because you will pass order information in JSON format using postman
	// ToDo If userid is not found then, this method throws exception with HTTP Status 500; It should send error with HTTP status 404; Not found 
	@PostMapping("/{userid}/orders")
	public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException{
		
		Optional<User> userOptional = userRepository.findById(userid);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User is not found; please check your input parameter");
		}
		
		User user = userOptional.get();
		order.setUser(user);
		return orderRepository.save(order);
		
	}
	
	
	@GetMapping("/{userid}/orders/{orderid}")
	public Optional<Order> getOrderByOrderId(@PathVariable Long userid, @PathVariable Long orderid) throws UserNotFoundException{
		
		Optional<User> userOptional = userRepository.findById(userid);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User is not found; please check your input parameter");
		}
		
		User user = userOptional.get();
		
		Optional<Order> orderOptional = orderRepository.findById(orderid);
		if(!orderOptional.isPresent()) {
			throw new UserNotFoundException("User found but, Order is not found; please check your input parameter");
		}
		return orderOptional;
	}
*/	
	
	//created method getAllorders
	@GetMapping("/{userid}/orders")
	public List<Order> getAllorders(@PathVariable Long userid) throws UserNotFoundException{
		try {
			return orderService.getAllorders(userid);
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
			}
	}
	
	// Add @RequestBody parameter because you will pass order information in JSON format using postman
	// ToDo If userid is not found then, this method throws exception with HTTP Status 500; It should send error with HTTP status 404; Not found 
	@PostMapping("/{userid}/orders")
	public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException{
		try {
			return orderService.createOrder(userid, order);
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
		
	}
	
	// ToDo If orderid is not found then, this method throws exception with HTTP Status 500; It should send error with HTTP status 404; Not found	
	@GetMapping("/{userid}/orders/{orderid}")
	public Optional<Order> getOrderByOrderId(@PathVariable Long userid, @PathVariable Long orderid) throws UserNotFoundException{
		
		try {
			return orderService.getOrderByOrderId(userid, orderid);
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage()); 
	}
	}

}
