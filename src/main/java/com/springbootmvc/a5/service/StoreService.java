package com.springbootmvc.a5.service;

import java.util.List;

import com.springbootmvc.a5.entity.Store;

public interface StoreService {

	String saveUser(Store store);

	List<Store> showAllUser();

	Store getUserDetails(String userName);

	Store getUserByEmail(String email);

}
