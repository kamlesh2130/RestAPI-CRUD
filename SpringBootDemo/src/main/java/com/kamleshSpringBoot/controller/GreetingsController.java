package com.kamleshSpringBoot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
@Autowired
Greetings greetings;
	
AtomicLong countId = new AtomicLong();

	@GetMapping("/greetings")
	public Greetings getGreetings(@RequestParam(value="name")String name) {
		
		greetings.setId(countId.incrementAndGet());
		greetings.setContent("Hi welcome to first Spring boot project "+ name);
		return greetings;
	}
	
}
