package com.fluxextreme.moneyflux.dataservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fluxextreme.moneyflux.dataservice.entities.MoneyFluxUser;

public interface MoneyFluxUserRepository extends MongoRepository<MoneyFluxUser, String> {

	List<MoneyFluxUser> findAll();

	MoneyFluxUser findByUserId(Long userId);
}
