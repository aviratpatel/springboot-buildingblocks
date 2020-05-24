/**
 * 
 */
package com.stacksimplify.restservices.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Avi Import ResponseEntityExceptionHandler and create your
 *         CustomGlobalExceptionHandler class by extending
 *         ResponseEntityExceptionHandler
 */
@ControllerAdvice // This is globally applicable to all of your controller classes
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// MethodArgumentNotValidException
	@Override // This will override same method exists in global
				// ResponseEntityExceptionHandler class
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
				"Error is shown From MethodArgumentNotValidException in Custom GlobalExceptionHandler class",
				ex.getMessage());

		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);

	}

	// HttpRequestMethodNotSupported
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
				"Method Not Allowed - Error is shown From handleHttpRequestMethodNotSupported in Custom GlobalExceptionHandler class",
				ex.getMessage());

		return new ResponseEntity<>(customErrorDetails, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	// UserNameNotFoundException
	@ExceptionHandler(UserNameNotFoundException.class) //Tell Spring to fire this exception using @ExceptionHandler annotation
	public final ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex, WebRequest request){
		
//		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
//				ex.getMessage(), request.getDescription(true));
//		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
//		ex.getMessage(), "Session ID:" + request.getSessionId()); //you can use any value using third parameter
		
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
		ex.getMessage(), request.getDescription(true));
		
		return new ResponseEntity<>(customErrorDetails, HttpStatus.NOT_FOUND);
	}
	
	//ConstraintViolationException
	@ExceptionHandler(ConstraintViolationException.class) //Import default javax.validation.ConstraintViolationException.class
	public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request){
		
		
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
		ex.getMessage(), request.getDescription(true));
		
		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}

}
