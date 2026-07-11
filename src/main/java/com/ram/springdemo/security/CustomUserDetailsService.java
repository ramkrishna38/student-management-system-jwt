package com.ram.springdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ram.springdemo.model.User;
import com.ram.springdemo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		
		User user=repository.findByUsername(username)
				.orElseThrow(()->new UsernameNotFoundException("User Not Found"));
		
		return new CustomUserDetails(user);
	}
}
