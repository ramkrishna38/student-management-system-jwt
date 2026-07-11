package com.ram.springdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.springdemo.model.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Integer>{
	
	Optional<RefreshToken> findByToken(String token);
	
	Optional<RefreshToken> findByUsername(String username);

}
