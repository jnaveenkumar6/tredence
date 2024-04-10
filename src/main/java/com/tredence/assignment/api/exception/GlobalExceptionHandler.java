package com.tredence.assignment.api.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	    @ResponseBody
	    @ExceptionHandler(DataSaveException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    ResponseEntity<String> dataException(HttpServletRequest request,
	            HttpServletResponse response, Exception ex) {
	    	return ResponseEntity.badRequest().body("ERROR");
	    }
	    
	    @ResponseBody
	    @ExceptionHandler(SearchException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    ResponseEntity<String> searchException(HttpServletRequest request,
	            HttpServletResponse response, Exception ex) {
	    	return ResponseEntity.badRequest().body("SEARCH ERROR");
	    }
	     
}
