package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class PermissionGranter extends ResourceServerConfigurerAdapter {

	// this method is used to configure the access rules
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/myresources/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/myresources/**").hasAnyRole("ADMIN", "GUEST")
		.antMatchers(HttpMethod.DELETE, "/myresources/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/myresources/**").hasAnyRole("ADMIN", "GUEST")
		.anyRequest().authenticated();
	}
}
