package com.citibank.citibankzuulapigatewayapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class CitibankZuulapiGatewayAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitibankZuulapiGatewayAppApplication.class, args);
	}

}
