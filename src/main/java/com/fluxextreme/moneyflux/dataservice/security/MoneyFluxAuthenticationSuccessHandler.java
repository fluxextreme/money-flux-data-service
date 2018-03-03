package com.fluxextreme.moneyflux.dataservice.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluxextreme.moneyflux.dataservice.objects.FEResponseBean;

@Component
public class MoneyFluxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {

		System.out.println("In Authentication Success Handler " + auth.getName());
		FEResponseBean responseBean = new FEResponseBean();
		responseBean.setAuthorizationPresent(true);
		responseBean.setLogin(true);
		responseBean.setSuccess(true);
		responseBean.setMessage("Login Success");
		responseBean.setData(auth);
		PrintWriter out = response.getWriter();
		out.println(objectMapper.writeValueAsString(responseBean));

	}

}
