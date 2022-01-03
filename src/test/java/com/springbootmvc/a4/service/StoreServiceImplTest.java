package com.springbootmvc.a4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springbootmvc.a4.entity.Store;
import com.springbootmvc.a4.repository.StoreRepository;

@RunWith(MockitoJUnitRunner.class)
public class StoreServiceImplTest {

	@InjectMocks
	StoreServiceImpl storeServiceImpl;

	@Mock
	StoreRepository storeRepository;
	
	@Mock
	BCryptPasswordEncoder passwordEncoder;


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveUser() {
		Store store = new Store();
		store.setUserId(1);
		store.setUserName("ABC123");
		store.setPassword("12345678");
		Mockito.when(storeRepository.save(store)).thenReturn(store);
		String storeReponse = storeServiceImpl.saveUser(store);
		Assert.assertEquals("Store data saved successfully", storeReponse);

	}

	@Test
	public void testShowAllUser() {
		List<Store> stores = new ArrayList<>();
		Store store = new Store();
		store.setUserName("ABC123");
		store.setPassword("test");
		Store store1 = new Store();
		store1.setUserName("ABC123");
		store1.setPassword("test");
		stores.add(store);
		stores.add(store1);
		Mockito.when(storeRepository.findAll()).thenReturn(stores);
		List<Store> storeReponse = storeServiceImpl.showAllUser();
		Assert.assertEquals(2, storeReponse.size());
	}

	@Test
	public void testGetUserByEmail() {
		Store store = new Store();
		store.setUserName("ABC123");
		store.setPassword("test");
		store.setEmail("ABC@gmail.com");
		Mockito.when(storeRepository.findByEmail(store.getEmail())).thenReturn(Optional.of(store));
		Store storeReponse = storeServiceImpl.getUserByEmail(store.getEmail());
		Assert.assertEquals(store.getUserName(), storeReponse.getUserName());
	}
}
