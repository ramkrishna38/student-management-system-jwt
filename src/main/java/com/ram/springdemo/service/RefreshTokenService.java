package com.ram.springdemo.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.springdemo.model.RefreshToken;
import com.ram.springdemo.repository.RefreshTokenRepository;

@Service
public class RefreshTokenService {
	
	@Autowired
	private RefreshTokenRepository repository;
	
	public RefreshToken createRefreshToken(String username) {
		repository.findByUsername(username).ifPresent(repository::delete);
		
		RefreshToken refreshToken =new RefreshToken();
		
		refreshToken.setUsername(username);
		
		refreshToken.setToken(UUID.randomUUID().toString());
		
		refreshToken.setExpiryDate(LocalDateTime.now().plusDays(7));
		
		return repository.save(refreshToken);
	}
	
	public RefreshToken verifyRefreshToken(String token) {
		
		RefreshToken refreshToken = repository.findByToken(token)
				.orElseThrow(()-> new RuntimeException("refresh Token Not Found"));
		
		if(refreshToken.getExpiryDate().isBefore(LocalDateTime.now())) {
			
			repository.delete(refreshToken);
			
			throw new RuntimeException("Refresh Token Expired");
		}
		
		return refreshToken;
	}
	
	
	public String refreshAccessToken(String refreshToken) {
		
		RefreshToken token = verifyRefreshToken(refreshToken);
		
		return token.getUsername();
	}
	
	
	

}
