package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

// this generates the token based on the configuration
// this also registers the application credentials
@Configuration
public class OAuth2TokenConfig extends AuthorizationServerConfigurerAdapter {

	// this object handles authentication
	@Autowired
	private AuthenticationManager authenticationManager;
	// this object maintains authenticate user details
	@Autowired
	private UserDetailsService userDetailsService;
	
	// token store
	@Autowired
	private TokenStore tokenStore;
	
	// token converter
	@Autowired
	public JwtAccessTokenConverter converter;
	
	// this method is automatically called, which will register the client application id, scope, grant types, password
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("my-client").secret("{noop}secretpassword")
		.authorizedGrantTypes("password").scopes("web", "mobile");
	}

	// this method is automatically called when you use /oauth/token, 
	// this will configure the endpoints to create the token based on the authenticated user & if any token enhancers like JWT
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
		.tokenStore(tokenStore)
		.accessTokenConverter(converter)
		.userDetailsService(userDetailsService);
	}
}
