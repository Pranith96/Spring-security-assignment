package com.springbootmvc.a4.service;

import java.util.List;

import com.springbootmvc.a4.entity.Store;

public interface StoreService {

	String saveUser(Store store);

	List<Store> showAllUser();

	Store getUserDetails(String userName);

	Store getUserByEmail(String email);

}
