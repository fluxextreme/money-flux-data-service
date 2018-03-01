package com.fluxextreme.moneyflux.dataservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fluxextreme.moneyflux.dataservice.objects.FEResponseBean;
import com.fluxextreme.moneyflux.dataservice.services.UserSettingsService;

@RestController
@RequestMapping("/settings")
public class UserSettingsController {
	
	@Autowired
	UserSettingsService userSettingsService;

	@RequestMapping(value = "/user-details/{userId}", method = RequestMethod.GET)
	public FEResponseBean getUserDetailsById(@PathVariable(name="userId") Long userId) {
		
		return userSettingsService.getUserDetailsById(userId);
	}
}
