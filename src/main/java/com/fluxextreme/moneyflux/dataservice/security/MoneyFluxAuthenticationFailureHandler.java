package com.fluxextreme.moneyflux.dataservice.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluxextreme.moneyflux.dataservice.objects.FEResponseBean;

@Component
public class MoneyFluxAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		System.out.println("Username::" + request.getParameter("username") + "---" + request.getParameter("password"));
		System.out.println("In Authentication Failure Handler " + exception.getMessage());
		System.out.println("In Login Failure");
		FEResponseBean responseBean = new FEResponseBean();
		responseBean.setAuthorizationPresent(false);
		responseBean.setLogin(false);
		responseBean.setSuccess(false);
		responseBean.setMessage("Login failed");
		responseBean.setData(exception.getMessage());
		PrintWriter out = response.getWriter();
		out.println(objectMapper.writeValueAsString(responseBean));
	}

}
