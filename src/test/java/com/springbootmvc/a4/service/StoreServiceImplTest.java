package com.springbootmvc.a4.service;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.springbootmvc.a4.entity.Store;
import com.springbootmvc.a4.repository.StoreRepository;

@RunWith(MockitoJUnitRunner.class)
public class StoreServiceImplTest {

	@InjectMocks
	StoreServiceImpl storeServiceImpl;

	StoreRepository storeRepository;

	@Before
	public void setUp() {
		storeRepository = mock(StoreRepository.class);
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSaveUser() {
		Store store = new Store();
		store.setUserName("ABC123");
		store.setPassword("test");
		Mockito.when(storeRepository.save(store)).thenReturn(store);
		String storeReponse = storeServiceImpl.saveUser(store);
		Assert.assertEquals("", storeReponse);

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
	public void testLoginUser() {
		Store store = new Store();
		store.setUserName("ABC123");
		store.setPassword("test");
		Store storeReponse = storeServiceImpl.loginUser(store.getUserName(), store.getPassword());
		Mockito.when(storeRepository.findByUserNameAndPassword(store.getUserName(), store.getPassword()))
				.thenReturn(Optional.of(store));
		Assert.assertEquals(store.getUserName(), storeReponse.getUserName());
	}

	@Test
	public void testGetUserByEmail() {
		Store store = new Store();
		store.setUserName("ABC123");
		store.setPassword("test");
		store.setEmail("ABC@gmail.com");
		Store storeReponse = storeServiceImpl.getUserByEmail(store.getEmail());
		Mockito.when(storeRepository.findByEmail(store.getEmail()))
				.thenReturn(Optional.of(store));
		Assert.assertEquals(store.getUserName(), storeReponse.getUserName());
	}

}
