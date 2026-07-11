package com.ram.springdemo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex){
	
	
	ErrorResponse error = new ErrorResponse(
			java.time.LocalDateTime.now(),
			HttpStatus.NOT_FOUND.value(),
			HttpStatus.NOT_FOUND.getReasonPhrase(),
			ex.getMessage());
			
	return new ResponseEntity<>(error,HttpStatus.NOT_FOUND); 
}

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ErrorResponse> handleValiation(MethodArgumentNotValidException ex){
//	
//	Map<String,String> errors =new HashMap<>();
//	
//	ex.getBindingResult().getFieldErrors().forEach(error ->{
//		errors.put(error.getField(),error.getDefaultMessage());
//	});
	
	StringBuilder builder = new StringBuilder();
	
	ex.getBindingResult().getFieldErrors().forEach(error->
			
	builder.append(error.getField())
			.append(" : ")
			.append(error.getDefaultMessage())
			.append(" | ")
			
		);
		
		ErrorResponse response = new ErrorResponse(
				
		java.time.LocalDateTime.now(),
		HttpStatus.BAD_REQUEST.value(),
		HttpStatus.BAD_REQUEST.getReasonPhrase(),
		builder.toString()
		
				);
				

	return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
}	


}
