package com.ram.springdemo.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.springdemo.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	Optional<User> findByUsername(String username);

}
