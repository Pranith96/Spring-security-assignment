package com.springbootmvc.a5.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springbootmvc.a5.entity.Store;
import com.springbootmvc.a5.service.StoreService;

@RestController
@RequestMapping("/store")
public class RegistrationController {
	private static final Logger logger = LogManager.getLogger(RegistrationController.class);

	@Autowired
	StoreService storeService;

	@GetMapping("/registration/page")
	public ModelAndView loadAddStorePage() {
		ModelAndView model = new ModelAndView();
		Store store = new Store();
		model.addObject("store", store);
		model.setViewName("registrationform");
		return model;
	}

	@PostMapping("/registration/save")
	public ModelAndView registerStore(@ModelAttribute Store user) {
		logger.info("before calling Service");
		String response = storeService.saveUser(user);
		logger.info("After calling Service");
		ModelAndView model = new ModelAndView();
		model.addObject("response", response);
		model.setViewName("registrationsuccess");
		return model;
	}
}
