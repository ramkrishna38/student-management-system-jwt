package com.ram.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.springdemo.dto.LoginRequest;
import com.ram.springdemo.dto.LoginResponse;
import com.ram.springdemo.dto.RefreshTokenRequest;
import com.ram.springdemo.dto.RefreshTokenResponse;
import com.ram.springdemo.security.JwtService;
import com.ram.springdemo.service.AuthenticationService;
import com.ram.springdemo.service.RefreshTokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private RefreshTokenService refreshTokenService;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		
		
		return authenticationService.login(
				request.getUsername(),
				request.getPassword());
				
				
		/*
		 * String token=authenticationService.login( request.getUsername(),
		 * request.getPassword());
		 * 
		 * return new LoginResponse(token);
		 */
	}

	@PostMapping("/refresh")
	public RefreshTokenResponse refreshToken(
			@RequestBody RefreshTokenRequest request) {
		
		String username= refreshTokenService
				.refreshAccessToken(request.getRefreshToken());
		
		String accessToken = jwtService.generateToken(username);
		
		return new RefreshTokenResponse(accessToken);
		
	}
	
}
