package com.springbootmvc.a4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootmvc.a4.entity.Store;
import com.springbootmvc.a4.repository.StoreRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Store storeDetails = storeRepository.findByUserName(userName);

		if (storeDetails == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new SecureUserDetails(storeDetails);
	}
}
