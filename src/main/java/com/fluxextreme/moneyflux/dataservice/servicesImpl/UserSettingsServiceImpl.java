package com.fluxextreme.moneyflux.dataservice.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluxextreme.moneyflux.dataservice.objects.FEResponseBean;
import com.fluxextreme.moneyflux.dataservice.repositories.MoneyFluxUserRepository;
import com.fluxextreme.moneyflux.dataservice.services.UserSettingsService;

@Service
public class UserSettingsServiceImpl implements UserSettingsService {

	@Autowired
	MoneyFluxUserRepository moneyFluxUserRepository;
	
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public FEResponseBean getUserDetailsById(Long userId) {

		FEResponseBean response = new FEResponseBean();
		response.setAuthorizationPresent(true);
		response.setLogin(true);
		try {
			response.setMessage("User details retrieval successfull");
			response.setData(moneyFluxUserRepository.findByUserId(userId));
			System.out.println("UserList:::::"+objectMapper.writeValueAsString(moneyFluxUserRepository.findAll()));
			System.out.println("UserObj:::::"+objectMapper.writeValueAsString(moneyFluxUserRepository.findByUserId(userId)));
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMessage("User details retrieval failure: " + e.getMessage());
			response.setSuccess(false);
		}
		return response;
	}

}
