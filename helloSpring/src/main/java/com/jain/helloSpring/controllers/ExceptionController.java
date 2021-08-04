package com.jain.helloSpring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jain.helloSpring.models.KeyNotFoundException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = KeyNotFoundException.class)
	public ResponseEntity<Object> keyNotFoundException(KeyNotFoundException exception) {
		
		return new ResponseEntity<Object>("No Data is found", HttpStatus.NOT_FOUND);
		
	}
	
	

}
