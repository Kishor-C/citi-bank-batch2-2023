package com.citibank.citibankwalletservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CitibankWalletServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitibankWalletServiceDemoApplication.class, args);
	}
	// Register the RestTemplate in the spring container
	// Use load balancer in the RestTemplate
	@Bean // Registers the object returned from this method in the spring container
	@LoadBalanced //Helps in resolving the physical address from the instance-id
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build(); // creates RestTemplate object & returns it
	}

}
