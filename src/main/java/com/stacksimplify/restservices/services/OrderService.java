/**
 * 
 */
package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;

/**
 * @author Avi
 * Created Service layer; 
 * Not created separate Service interface class and Service implementation class for project simplification 
 * Service Layer to throw exception and pass it to controller class so that we can define proper error message
 */

@Service // Import package org.springframework.stereotype.Service
public class OrderService {
	
	// Autowire User repository
	@Autowired
	private UserRepository userRepository;
	
	// Autowire Order repository
	@Autowired
	private OrderRepository orderRepository;
	
	
	public List<Order> getAllorders(@PathVariable Long userid) throws UserNotFoundException{
		
		Optional<User> userOptional = userRepository.findById(userid);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User is not found; please check your input parameter");
		}
		
		return userOptional.get().getOrders();
	}
	

	public Order createOrder(@PathVariable Long userid, Order order) throws UserNotFoundException{
		
		Optional<User> userOptional = userRepository.findById(userid);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User is not found; please check your input parameter");
		}
		
		User user = userOptional.get();
		order.setUser(user);
		return orderRepository.save(order);
		
	}
	
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

}
