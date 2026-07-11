package com.ram.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.ram.springdemo.dto.LoginResponse;
import com.ram.springdemo.model.RefreshToken;
import com.ram.springdemo.security.JwtService;

@Service
public class AuthenticationService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private RefreshTokenService refreshTokenService;
	
	public LoginResponse login(String username, String password) {
		
		authenticationManager.authenticate(
				
				new UsernamePasswordAuthenticationToken(username, password));
		
		String accessToken= jwtService.generateToken(username);
		
		RefreshToken refreshToken = 
				refreshTokenService.createRefreshToken(username);
		
		return new LoginResponse(
				accessToken,
				refreshToken.getToken());
				
				
				
		
	}
	}
	
	
	
/*
 * public String login(String username,String password) {
 * 
 * authenticationManager.authenticate(
 * 
 * new UsernamePasswordAuthenticationToken(username,password) );
 * 
 * return jwtService.generateToken(username);
 * 
 * }
 * 
 * }
 */