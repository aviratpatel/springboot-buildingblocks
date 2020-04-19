/**
 * 
 */
package com.stacksimplify.restservices.exceptions;

/**
 * @author Avi
 * 20200419 Created first version with help of Udemy Course
 * https://wipro.udemy.com/course/master-restful-apis-with-spring-boot/learn/lecture/15745794#overview
 *
 */
public class UserNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param arg0
	 */
	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
