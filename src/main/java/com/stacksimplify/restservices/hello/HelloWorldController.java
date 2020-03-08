/**
 * 
 */
package com.stacksimplify.restservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Avi
 * Created a controller for Srping boot class file Application.java
 */
@RestController

public class HelloWorldController {

	// Simple method; GET method
	// Uniform Resource Identifier(URI): /helloworld
	@RequestMapping(method=RequestMethod.GET, path="/helloworld")
	public String helloworld() {
		return "<b> My first Spring boot program that returns a string; "
				+ "<br> Courtesy: Udemy course of spring boot buildingblocks </b>"; 
	}
	
	//Another method is to use GetMapping annotation
	@GetMapping("/")
	public String helloworld1() {
		return "<b> Welcome to world of happiness... Krishna loves you!"
				+ "<br> Courtesy: Udemy course of spring boot buildingblocks </b>"; 
	}
 
	@GetMapping("/helloworld-bean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Avirat", "Patel", "Surat");
	}
}
