package com.ram.springdemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ram.springdemo.model.User;
import com.ram.springdemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User registerUser(User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return repository.save(user);
	}
}
