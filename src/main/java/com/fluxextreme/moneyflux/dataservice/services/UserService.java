package com.fluxextreme.moneyflux.dataservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fluxextreme.moneyflux.dataservice.objects.FEResponseBean;

public interface UserService {

	FEResponseBean getUserDetailsByUsername(String username) throws JsonProcessingException;
}
