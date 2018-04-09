package com.fluxextreme.moneyflux.dataservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootConfiguration
public class MoneyFluxSpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MoneyFluxUserDetailsService moneyFluxUserDetailsService;
	
	@Autowired
	private MoneyFluxAccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	private MoneyFluxAuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	private MoneyFluxAuthenticationFailureHandler authenticationFailureHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(moneyFluxUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
		.antMatchers("/money-flux-dataservice/*").permitAll()
		.antMatchers("/user").hasAnyRole("USER")
		.antMatchers("/admin").hasAnyRole("ADMIN")
		/*.anyRequest().authenticated()*/
		.and()
		.formLogin()
		.usernameParameter("username")
		.passwordParameter("password")
		.loginProcessingUrl("/login-security-check").successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler).permitAll()
		.and()
		.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}
	
}
