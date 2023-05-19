package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class JwtConfig {

	// key for signature, usually kept in the configuration file 
	// are passed in the command line argument & extract with @Value(${property})
	private String key = "ABC12345XYZKJDF";
	
	// token converter
	@Bean
	public JwtAccessTokenConverter jwtConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(key);
		return converter;
	}
	// token store stores the token while converting
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtConverter());
	}
}
