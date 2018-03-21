package com.fluxextreme.moneyflux.dataservice.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.fluxextreme.moneyflux.dataservice.MoneyFluxMongoConfiguration;
import com.fluxextreme.moneyflux.dataservice.entities.MoneyFluxUser;

@Component
public class MoneyFluxUserDetailsService implements UserDetailsService {

	@Autowired
	MoneyFluxMongoConfiguration mongodbConfig;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		MongoTemplate mongoTemplate = mongodbConfig.mongoTemplate();
		System.out.println("username:::::::"+username);
		Query userDetailsQuery = Query.query(Criteria.where("username").is(username.toLowerCase()));
		List<MoneyFluxUser> userDetailsList = mongoTemplate.find(userDetailsQuery, MoneyFluxUser.class);
		System.out.println("........."+userDetailsList.size());
		
		
		if (userDetailsList.size() == 1) {
			MoneyFluxUser user=userDetailsList.stream().findFirst().get();
			//Important update: Originally we use new String[list.size()]. However, due to JVM optimizations, using new String[0] is better now.
			return new MoneyFluxUserDetails(user.getUsername(), user.getPassword(),
					user.getAuthorities().toArray(new String[0]), user.isAccountNonExpired(), user.isAccountNonLocked(),
					user.isCredentailsNonExpired(), user.isEnabled());
		} else if (userDetailsList.size() <= 0) {
			System.out.println("User doesn't exist");
		} else {
			System.out.println("More than one user exits with same username.");
		}
		
		return null;
	}

}
