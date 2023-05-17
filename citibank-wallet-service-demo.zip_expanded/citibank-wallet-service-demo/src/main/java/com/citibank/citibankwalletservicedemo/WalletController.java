package com.citibank.citibankwalletservicedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // registers this object in the spring container
@RequestMapping("/wallet")
public class WalletController {

	// spring must supply WalletService object to call the initializeWallet() method
	@Autowired
	private WalletService service;
	
	@GetMapping("/fetchBalance")
	public ResponseEntity<Object> fetchBalance() {
		Wallet wallet = service.initializeWallet(); 
		return ResponseEntity.status(200).body(wallet);
	}
}
