package com.ffc.exception;

import java.io.IOException;
import java.time.LocalDate;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalRestExceptionHandler {
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<ResponseError> IOExceptionHandler(IOException e,HttpServletRequest request){
		ResponseError error = new ResponseError(LocalDate.now(),HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND,e.getMessage(),request.getRequestURI());
		return new ResponseEntity<ResponseError>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MessagingException.class)
	public ResponseEntity<ResponseError> MessagingExceptionHandler(MessagingException e,HttpServletRequest request){
		ResponseError error = new ResponseError(LocalDate.now(),HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND,e.getMessage(),request.getRequestURI());
		return new ResponseEntity<ResponseError>(error, HttpStatus.NOT_FOUND);
	}
}
