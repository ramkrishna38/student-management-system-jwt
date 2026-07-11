package com.ram.springdemo.dto;

public class RefreshTokenResponse {

	private String accessToken;
	
	public RefreshTokenResponse() {
		
	}
	
	public RefreshTokenResponse(String accessToken) {
		this.accessToken=accessToken;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessTokan(String accessToken) {
		this.accessToken=accessToken;
	}
	
}
