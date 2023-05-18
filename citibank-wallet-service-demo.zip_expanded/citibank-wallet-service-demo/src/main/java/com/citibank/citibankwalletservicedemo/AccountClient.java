package com.citibank.citibankwalletservicedemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("http://AMS/")
public interface AccountClient {

	// a method that will have a GET mapping with the URL
	@GetMapping("/account/balance")
	public Wallet fetchAccountBalance(); // on calling this an HTTP GET request will be sent to http://AMS/account/balance
}
