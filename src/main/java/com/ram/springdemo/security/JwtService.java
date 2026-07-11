package com.ram.springdemo.security;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
	
	
	@Value("${jwt.secret}")
	private String secret;
	
	private Key getSignKey() {
		return Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	public String generateToken(String username) {
		
		return Jwts.builder()
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+1000*60*60))
				.signWith(getSignKey())
				.compact();
	}
	
	public String extractUsername(String token) {
		return extractClaim(token,Claims::getSubject);
	}
	
	public <T> T extractClaim(String token, Function<Claims,T>resolver) {
		
		Claims claims=extractAllClaims(token);
		
		return resolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
		
		return Jwts.parser()
				.verifyWith((SecretKey) getSignKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	public boolean isTokenExpired(String token) {
		
		return extractClaim(token, Claims::getExpiration).before(new Date());
	}
	
	public boolean isTokenValid(String token, UserDetails userDetails) {
		
		String username =extractUsername(token);
		
		return username.equals(userDetails.getUsername())&& !isTokenExpired(token);
	}

}