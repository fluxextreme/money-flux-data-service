package com.fluxextreme.moneyflux.dataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class MoneyFluxDataserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyFluxDataserviceApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/").allowedOrigins("/").allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedHeaders("Access-Control-Allow-Origin", "header2", "header3")
						.exposedHeaders("header1", "header2");
			}
		};
	}
}
