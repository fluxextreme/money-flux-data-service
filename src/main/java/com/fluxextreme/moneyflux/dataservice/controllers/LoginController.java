package com.fluxextreme.moneyflux.dataservice.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fluxextreme.moneyflux.dataservice.entities.User;
import com.fluxextreme.moneyflux.dataservice.objects.FEResponseBean;
import com.fluxextreme.moneyflux.dataservice.objects.UserLoginDetails;

@RestController(value = "/login-service")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public FEResponseBean login(@RequestBody UserLoginDetails userLoginDetails) {

		FEResponseBean response = new FEResponseBean();
		response.setAuthorizationPresent(true);
		response.setLogin(true);
		response.setMessage("Login successfull");
		response.setData(userLoginDetails);
		return response;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public FEResponseBean register(@RequestBody User user) {

		FEResponseBean response = new FEResponseBean();
		response.setAuthorizationPresent(true);
		response.setLogin(true);
		response.setMessage("Registration successfull");
		response.setData(user);
		return response;
	}
}
