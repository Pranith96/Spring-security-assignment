package com.springbootmvc.a5.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class AddStoreController {

    private static final Logger logger = LogManager.getLogger(AddStoreController.class);

	@Autowired
	StoreService storeService;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
	@GetMapping("/details/page")
	public ModelAndView loadAddStorePage() {
		ModelAndView model = new ModelAndView();
		Store store = new Store();
		model.addObject("store", store);
		model.setViewName("addstoreform");
		return model;
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
	@PostMapping("/details/save")
	public ModelAndView registerStore(@ModelAttribute Store user) {
        logger.info("before calling Service");
		String response = storeService.saveUser(user);
        logger.info("After calling Service");
		ModelAndView model = new ModelAndView();
		model.addObject("response", response);
		model.setViewName("addstoredetailsuccess");		
		return model;
	}
}
