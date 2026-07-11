package com.ram.springdemo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RefreshToken {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	
	private String token;
	
	private String username;
	
	private LocalDateTime expiryDate;
	
	public RefreshToken() {
		
	}
	
	public RefreshToken(Integer id, String token, String username, LocalDateTime expiryDate) {
		
		this.id=id;
		this.token=token;
		this.username=username;
		this.expiryDate=expiryDate;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token=token;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	
	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate=expiryDate;
	}
}
