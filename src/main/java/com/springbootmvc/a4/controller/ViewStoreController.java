package com.springbootmvc.a4.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springbootmvc.a4.entity.Store;
import com.springbootmvc.a4.service.StoreService;

@RestController
@RequestMapping("/store")
public class ViewStoreController {

    private static final Logger logger = LogManager.getLogger(ViewStoreController.class);

	@Autowired
	StoreService userService;
	
	@GetMapping("/get/details")
	public ModelAndView getAllUser(){
        logger.info("before calling Service to fetch list details");
		List<Store> response = userService.showAllUser();
        logger.info("after calling Service to fetch list details");
        ModelAndView model = new ModelAndView();
		model.addObject("response", response);
		model.setViewName("homepage");		
		return model;
	}
	
	@GetMapping("/get/user/{userName}")
	public Store getUser(@PathVariable("userName") String userName){
        logger.info("before calling Service to fetch store details");
		Store response = userService.getUserDetails(userName);
        logger.info("before calling Service to fetch store details");
		return response;
	}
	
	@GetMapping("/get/email")
	public ModelAndView getUserByEmail(@RequestParam("email") String email){
        logger.info("before calling Service to fetch store details by email");
		Store store = userService.getUserByEmail(email);
        logger.info("before calling Service to fetch store details by email");
		ModelAndView model = new ModelAndView();
		model.addObject("store", store);
		model.setViewName("viewstore");	
		return model;
	}
}
