package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

// configures user credentials & also objects like Authentication Manager & User Details Service
@Configuration
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
	// method that registers the AuthenticationManager as a bean so that it can be autowired
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	// method that registers the UserDetailsService as a bean so that it can be autowired
	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}
	// method that registers the user credentials & roles
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("alex").password("{noop}alex123").roles("ADMIN", "USER")
		.and()
		.withUser("bruce").password("{noop}bruce123").roles("GUEST");
	}
	
}
