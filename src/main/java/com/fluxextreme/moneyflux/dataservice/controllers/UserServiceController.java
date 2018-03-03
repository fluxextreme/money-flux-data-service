package com.fluxextreme.moneyflux.dataservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fluxextreme.moneyflux.dataservice.objects.FEResponseBean;
import com.fluxextreme.moneyflux.dataservice.services.UserService;
import com.fluxextreme.moneyflux.dataservice.services.UserSettingsService;

@RestController
@RequestMapping("/user-service")
public class UserServiceController {
	
	@Autowired
	UserSettingsService userSettingsService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/user-details-by-userid/{userId}", method = RequestMethod.GET)
	public FEResponseBean getUserDetailsById(@PathVariable(name="userId") Long userId) {
		System.out.println("...............");
		return userSettingsService.getUserDetailsById(userId);
	}
	
	@RequestMapping(value="/user-details-by-username/{username}")
	public FEResponseBean getUserDetailsByUsername(@PathVariable(name="username") String username) throws JsonProcessingException {
		System.out.println("*************");
		return userService.getUserDetailsByUsername(username);
	}
}
