/**
 * 
 */
package com.stacksimplify.restservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
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
import com.stacksimplify.restservices.services.OrderService;

/**
 * @author Avi
 *
 */
@RestController
@Validated
@RequestMapping(value = "/hateoas/users")  // import org.springframework.web.bind.annotation.RequestMapping package
public class OrderHateoasController {
	
	// Autowired OrderService
	@Autowired
	private OrderService orderService;
	
	//created method getAllorders
	@GetMapping("/{userid}/orders")
	public CollectionModel<Order> getAllorders(@PathVariable Long userid) throws UserNotFoundException{
		try {
			//return orderService.getAllorders(userid);
			List<Order> allorders = orderService.getAllorders(userid);
			
			for (Order order : allorders) {
				//Self Link
				long orderid = order.getOrderid(); // We need variable to do self linking while calling slash method
				Link selflink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userid).slash("orders").slash(orderid).withSelfRel();
				order.add(selflink);	
			}
			
			CollectionModel<Order> finalResource = new CollectionModel<Order>(allorders);
			return finalResource; // Resource object is replaced by EntityModel object in HATEOAS new version
			
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
			}
	}

//	TO DO: Add all other methods that we have in OrderController
}
