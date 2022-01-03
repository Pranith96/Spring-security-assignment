package com.springbootmvc.a4.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.springbootmvc.a4.entity.Store;
import com.springbootmvc.a4.service.StoreServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ViewStoreControllerTest {

	@InjectMocks
	ViewStoreController viewStoreController;

	@Mock
	StoreServiceImpl storeServiceImpl;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllUser() {
		List<Store> stores = new ArrayList<>();
		when(storeServiceImpl.showAllUser()).thenReturn(stores);
		ModelAndView mav = viewStoreController.getAllUser();
		Assert.assertEquals("homepage", mav.getViewName());
	}
	
	@Test
	public void testGetUserByEmail() {
		String email = "test@gmail.com";
		when(storeServiceImpl.getUserByEmail(Mockito.anyString())).thenReturn(Mockito.any(Store.class));
		ModelAndView mav = viewStoreController.getUserByEmail(email);
		Assert.assertEquals("viewstore", mav.getViewName());
	}
}
