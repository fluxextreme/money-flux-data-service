package com.fluxextreme.moneyflux.dataservice.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.fluxextreme.moneyflux.dataservice.repositories.UserRepository;
import com.fluxextreme.moneyflux.dataservice.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	UserRepository userRepository;

}
