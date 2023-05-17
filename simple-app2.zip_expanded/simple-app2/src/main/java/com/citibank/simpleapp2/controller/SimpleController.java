package com.citibank.simpleapp2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class SimpleController {

	@GetMapping(path = "/test")
	public ResponseEntity<Object> greet() {
		double random = Math.random(); // 0 to 1
		if(random > 0.5) {
			return ResponseEntity.status(200).body("This is a string message, random number "+random);
		}
		else {
			Map<String, String> map = new HashMap<>();
			map.put("message", "Hello everyone, random number "+random);
			map.put("name", "Alex");
			return ResponseEntity.status(201).body(map);
		}
	}	
}
