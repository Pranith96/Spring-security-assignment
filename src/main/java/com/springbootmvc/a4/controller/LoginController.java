package com.springbootmvc.a4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.springbootmvc.a4.dto.StoreDto;
import com.springbootmvc.a4.entity.Store;
import com.springbootmvc.a4.service.StoreService;

@RestController
@RequestMapping("/store")
public class LoginController {

	private static final Logger logger = LogManager.getLogger(ViewStoreController.class);

	@Autowired
	StoreService userService;

	@GetMapping("/login/page")
	public ModelAndView loadLoginPage() {
		ModelAndView model = new ModelAndView();
		StoreDto store = new StoreDto();
		model.addObject("store", store);
		model.setViewName("login");
		return model;
	}

	@PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
	@PostMapping("/login/check")
	public ModelAndView loginStore(@ModelAttribute StoreDto userDto, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		logger.info("before calling Service for login");
		Store userResponse = userService.loginUser(userDto.getUserName(), userDto.getPassword());
		logger.info("After calling Service for login");
		if (null == userResponse) {
			ModelAndView model = new ModelAndView();
			StoreDto user = new StoreDto();
			model.addObject("user", user);
			model.addObject("response", "Login Failed. Please Enter Valid credentials");
			model.setViewName("failedlogin");
			return model;
		} else {
			ModelAndView model = new ModelAndView();
			String greeting = "Welcome " + userResponse.getName() + "..!!";
			model.addObject("response", "Successfully LoggedIn" + " " + userResponse.getName());
			model.setViewName("loginsuccess");
			session.setAttribute("greeting", greeting);
			session.setAttribute("userName", userResponse.getUserName());
			return model;
		}
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("logout");
		return model;
	}
}
