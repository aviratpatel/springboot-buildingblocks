/**
 * 
 */
package com.stacksimplify.restservices.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Avi
 *
 */
//@RestControllerAdvice

public class GlobalRestControllerAdviceExceptionHandler {

	@ExceptionHandler(UserNameNotFoundException.class) //Tell Spring to fire this exception using @ExceptionHandler annotation
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomErrorDetails usernameNotFound(UserNameNotFoundException ex) {
		return new CustomErrorDetails(new Date(), "From @RestControllerAdvice; username not found", ex.getMessage());
	}
}
