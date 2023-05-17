package com.citibank.citibankaccountservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // registers the instance in the service discovery
public class CitibankAccountServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitibankAccountServiceDemoApplication.class, args);
	}

}
