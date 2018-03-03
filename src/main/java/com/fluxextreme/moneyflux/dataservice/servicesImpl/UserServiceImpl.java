package com.fluxextreme.moneyflux.dataservice.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluxextreme.moneyflux.dataservice.MoneyFluxMongoConfiguration;
import com.fluxextreme.moneyflux.dataservice.entities.MoneyFluxUser;
import com.fluxextreme.moneyflux.dataservice.objects.FEResponseBean;
import com.fluxextreme.moneyflux.dataservice.repositories.MoneyFluxUserRepository;
import com.fluxextreme.moneyflux.dataservice.security.MoneyFluxUserDetails;
import com.fluxextreme.moneyflux.dataservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	MoneyFluxMongoConfiguration mongodbConfig;

	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	MoneyFluxUserRepository moneyFluxUserRepository;

	@Override
	public FEResponseBean getUserDetailsByUsername(String username) throws JsonProcessingException {
		
		List<MoneyFluxUser> usersList= moneyFluxUserRepository.findAll();
		System.out.println("User Details List Size::::"+usersList.size());
		System.out.println(objectMapper.writeValueAsString(usersList.stream().findFirst().get()));

		FEResponseBean response = new FEResponseBean();
		MongoTemplate mongoTemplate = mongodbConfig.mongoTemplate();
		Query userDetailsQuery = Query.query(Criteria.where("username").is("user@gmail.com"));
		List<MoneyFluxUserDetails> userDetailsList = mongoTemplate.find(userDetailsQuery, MoneyFluxUserDetails.class);
		System.out.println("User Details List Size::::"+userDetailsList.size());
		System.out.println(objectMapper.writeValueAsString(userDetailsList.stream().findFirst().get()));

		return response;
	}
}
