package com.springbootmvc.a4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AccessDeniedController {
	
	@GetMapping("/accessdenied")
	public ModelAndView error403() {
		ModelAndView model = new ModelAndView();
		model.setViewName("accessdenied");
		return model;
	}
	
}
