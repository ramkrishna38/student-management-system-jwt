package com.ram.springdemo.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	public  ResourceNotFoundException (String message) {
		super(message);
	}

}
