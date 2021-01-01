/**
 * 
 */
package com.stacksimplify.restservices.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Avi
 * Created a controller for Srping boot class file Application.java
 */
@RestController

public class HelloWorldController {
	
	// Used to show messages in other language; look at method getMessagesInI18Format() as below
	@Autowired
	private ResourceBundleMessageSource messageSource;

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
	
	@GetMapping("/hello-int")
	public String getMessagesInI18Format(@RequestHeader(name = "Accept-Language", required=false) String locale) {
		//return "Hello World I18N";
		return  messageSource.getMessage("label.hello", null, new Locale(locale));
	}
	
	@GetMapping("/hello-int2")
	public String getMessagesInI18Format2() {
		//return "Hello World I18N";
		return  messageSource.getMessage("label.hello", null, LocaleContextHolder.getLocale());
	}
}
