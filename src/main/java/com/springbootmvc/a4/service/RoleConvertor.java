package com.springbootmvc.a4.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.springbootmvc.a4.controller.ViewStoreController;
import com.springbootmvc.a4.entity.Role;
import com.springbootmvc.a4.repository.RoleRepository;

@Component
public class RoleConvertor implements Converter<String, Role> {
    private static final Logger logger = LogManager.getLogger(ViewStoreController.class);

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role convert(String source) {
        logger.info("before calling role converter");
		return roleRepository.findByUserRole(source);
	}

}
