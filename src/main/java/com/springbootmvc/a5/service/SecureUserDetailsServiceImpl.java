package com.springbootmvc.a5.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootmvc.a5.entity.Store;
import com.springbootmvc.a5.repository.StoreRepository;

@Service
public class SecureUserDetailsServiceImpl implements UserDetailsService {

	private static final Logger logger = LogManager.getLogger(SecureUserDetailsServiceImpl.class);

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		logger.info("in  userdetails service");
		Store storeDetails = storeRepository.findByUserName(userName);

		if (storeDetails == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new SecureUserDetails(storeDetails);
	}
}
