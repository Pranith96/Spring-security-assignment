package com.springbootmvc.a5.controller;

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

import com.springbootmvc.a5.entity.Store;
import com.springbootmvc.a5.service.StoreServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AddStoreControllerTest {

	@InjectMocks
	AddStoreController addStoreController;

	@Mock
	StoreServiceImpl storeServiceImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLoadLoginPage() {
		ModelAndView mav = addStoreController.loadAddStorePage();
		Assert.assertEquals("addstoreform", mav.getViewName());
	}

	@Test
	public void testCreateUser() {
		Store store = new Store();
		Mockito.when(storeServiceImpl.saveUser(store)).thenReturn(Mockito.anyString());
		ModelAndView mav = addStoreController.registerStore(store);
		Assert.assertEquals("addstoredetailsuccess", mav.getViewName());
	}

}
