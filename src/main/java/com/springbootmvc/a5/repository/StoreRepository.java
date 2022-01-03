package com.springbootmvc.a5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootmvc.a5.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {	
 
	public Store findByUserName(String username);

	public Optional<Store> findByUserNameAndPassword(String userName, String password);

	public Optional<Store> findByEmail(String email);

}
