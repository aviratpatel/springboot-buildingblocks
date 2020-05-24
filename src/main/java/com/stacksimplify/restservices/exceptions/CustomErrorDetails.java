/**
 * 
 */
package com.stacksimplify.restservices.exceptions;

import java.util.Date;

/**
 * @author Avi
 * Create Simple Custom Error Details Bean
 */
public class CustomErrorDetails {

	private Date timestamp;
	private String message;
	private String errordetails;
	
	
	/** Field Constructors
	 * @param timestamp
	 * @param message
	 * @param errordetails
	 */
	public CustomErrorDetails(Date timestamp, String message, String errordetails) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errordetails = errordetails;
	}
	
	/** GETTERS
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the errordetails
	 */
	public String getErrordetails() {
		return errordetails;
	}
	
	
}
