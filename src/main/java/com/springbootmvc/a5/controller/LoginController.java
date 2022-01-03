package com.springbootmvc.a5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springbootmvc.a5.dto.StoreDto;
import com.springbootmvc.a5.service.StoreService;

@RestController
@RequestMapping("/store")
public class LoginController {

	private static final Logger logger = LogManager.getLogger(ViewStoreController.class);

	@Autowired
	StoreService userService;

	@Autowired
	AuthenticationManager authentication;

	@GetMapping("/login/page")
	public ModelAndView loadLoginPage() {
		ModelAndView model = new ModelAndView();
		StoreDto store = new StoreDto();
		model.addObject("store", store);
		model.setViewName("login");
		return model;
	}

	@PostMapping("/login/check")
	public ModelAndView loginStore(@ModelAttribute StoreDto userDto, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String userName = userDto.getUserName();
		String password = userDto.getPassword();
		logger.info("Before login");
		try {
			Authentication auth = authentication
					.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
			SecurityContextHolder.getContext().setAuthentication(auth);
			logger.info("After login");
			ModelAndView model = new ModelAndView();
			String greeting = "Welcome " + userName + "..!!";
			model.addObject("response", "Successfully LoggedIn" + " " + userName);
			model.setViewName("loginsuccess");
			session.setAttribute("greeting", greeting);
			session.setAttribute("userName", userName);
			return model;
		} catch (BadCredentialsException ex) {
			logger.info("Bad creddentials: ", ex.getMessage());
			ModelAndView model = new ModelAndView();
			StoreDto user = new StoreDto();
			model.addObject("user", user);
			model.addObject("response", "Login Failed. Please Enter Valid credentials");
			model.addObject("exception", ex.getMessage());
			model.setViewName("failedlogin");
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
