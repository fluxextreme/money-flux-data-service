package com.fluxextreme.moneyflux.dataservice.controllers;

import javax.naming.AuthenticationException;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fluxextreme.moneyflux.dataservice.entities.MoneyFluxUser;
import com.fluxextreme.moneyflux.dataservice.objects.FEResponseBean;

@RestController
@RequestMapping(value = "/login-service")
public class LoginController {

	@RequestMapping(value = "/login/success", method = RequestMethod.POST)
	public FEResponseBean loginSuccess(@RequestAttribute(name = "authentication") Authentication authentication) {

		System.out.println("In Login Success");
		FEResponseBean response = new FEResponseBean();
		response.setAuthorizationPresent(true);
		response.setLogin(true);
		response.setMessage("Login successfull");
		response.setData(authentication);
		return response;
	}

	@RequestMapping(value = "/login/failure", method = RequestMethod.POST)
	public FEResponseBean loginFailure(@RequestAttribute(name = "exception") AuthenticationException exception) {

		System.out.println("In Login Failure");
		FEResponseBean response = new FEResponseBean();
		response.setAuthorizationPresent(true);
		response.setLogin(true);
		response.setMessage("Login failed");
		response.setData(exception);
		return response;
	}

	@RequestMapping(value = "/signup-with/email", method = RequestMethod.POST)
	public FEResponseBean register(@RequestBody MoneyFluxUser moneyFluxUser) {

		System.out.println("In Signup.......");
		FEResponseBean response = new FEResponseBean();
		response.setAuthorizationPresent(true);
		response.setLogin(true);
		response.setMessage("Registration successfull");
		response.setData(moneyFluxUser);
		return response;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public FEResponseBean test() {

		System.out.println("In Signup.......");
		FEResponseBean response = new FEResponseBean();
		response.setAuthorizationPresent(true);
		response.setLogin(true);
		response.setMessage("Registration successfull");
		response.setData(null);
		return response;
	}

}
