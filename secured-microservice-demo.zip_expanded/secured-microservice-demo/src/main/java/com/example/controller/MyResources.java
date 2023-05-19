package com.example.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("myresources")
public class MyResources {

	@PostMapping
	public String store() {
		return "Store resource";
	}
	@GetMapping
	public String fetch() {
		return "Fetch resource";
	}
	
	@PutMapping
	public String update() {
		return "Update resource";
	}
	@DeleteMapping
	public String delete() {
		return "Delete resource";
	}
}
