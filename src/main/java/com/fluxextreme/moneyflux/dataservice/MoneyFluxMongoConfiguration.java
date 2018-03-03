package com.fluxextreme.moneyflux.dataservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class MoneyFluxMongoConfiguration {

	public @Bean MongoDbFactory mongodbFactory() {
		return new SimpleMongoDbFactory(new MongoClient("127.0.0.1"), "moneyflux");
	}

	public @Bean MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongodbFactory());
	}
}
