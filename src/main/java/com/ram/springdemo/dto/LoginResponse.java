package com.ram.springdemo.dto;

public class LoginResponse {
	
	private String accessToken;
	
	private String refreshToken;
	
	public LoginResponse() {
		
	}
	
	public LoginResponse(String accessToken, String refreshToken) {
		this.accessToken=accessToken;
		this.refreshToken=refreshToken;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String acceessToken) {
		this.accessToken=accessToken;
	}
	
	public String getRefreshToken() {
		return refreshToken;
	}
	
	public void setRefreshToken(String refreshToken) {
		this.refreshToken=refreshToken;
	}
	
	/*
	 * private String token;
	 * 
	 * public LoginResponse() {
	 * 
	 * }
	 * 
	 * public LoginResponse(String token) { this.token=token; }
	 * 
	 * public String getToken() { return token; }
	 * 
	 * public void setToken(String token) { this.token=token; }
	 */
}
