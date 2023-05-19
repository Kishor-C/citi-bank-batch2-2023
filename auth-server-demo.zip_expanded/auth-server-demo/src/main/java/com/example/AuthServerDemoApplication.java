package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer // acts as authentication server
@EnableResourceServer // accepts the token for validation
@RestController
public class AuthServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerDemoApplication.class, args);
	}
	// end point for protected services to share the token here & get the user details with roles
	// this end point can be accessed using /user & any HTTP method
	// this method accepts the token which will have user & client info & returns the user details with roles
	@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> users(OAuth2Authentication oauth2) {
		Map<String, Object> details = new HashMap<String, Object>();
		// store the authenticated user in a key 'user'
		details.put("user", oauth2.getUserAuthentication().getPrincipal());
		// store the authenticated user roles
		details.put("authorities", oauth2.getUserAuthentication().getAuthorities());
		return details;
	}
}
