package com.springbootmvc.a5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbootmvc.a5.entity.Store;
import com.springbootmvc.a5.exception.StoreNotFoundException;
import com.springbootmvc.a5.repository.StoreRepository;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

	private static final Logger logger = LogManager.getLogger(StoreServiceImpl.class);

	@Autowired
	StoreRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public String saveUser(Store user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		logger.info("In service class save method");
		Store response = userRepository.save(user);
		if (response == null) {
			return "Store data not saved";
		}
		return "Store data saved successfully";
	}

	public List<Store> showAllUser() {
		logger.info("In service class fetch all store");
		List<Store> user = userRepository.findAll();
		if (null == user || user.isEmpty()) {
			throw new StoreNotFoundException("Store is Empty");
		}
		return user;
	}

	@Override
	public Store getUserDetails(String userName) {
		logger.info("In service class fetch store");
		Store userResponse = userRepository.findByUserName(userName);
		if (userResponse == null) {
			throw new StoreNotFoundException("User Name doesnt exists");
		}
		return userResponse;
	}

	@Override
	public Store getUserByEmail(String email) {
		logger.info("In service class fetch store");
		Optional<Store> userResponse = userRepository.findByEmail(email);
		if (!userResponse.isPresent()) {
			throw new StoreNotFoundException("No Store exists for provided email");
		}
		return userResponse.get();
	}

}
