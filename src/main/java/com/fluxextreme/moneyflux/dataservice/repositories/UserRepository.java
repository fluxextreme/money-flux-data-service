package com.fluxextreme.moneyflux.dataservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fluxextreme.moneyflux.dataservice.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

	List<User> findAll();

	User findByUserId(Long userId);
}
