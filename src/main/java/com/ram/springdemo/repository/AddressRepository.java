package com.ram.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.springdemo.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
