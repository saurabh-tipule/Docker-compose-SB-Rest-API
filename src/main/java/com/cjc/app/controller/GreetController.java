package com.cjc.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping(value = "/greet")
	public String greetMsg() {
		String msg = "Good AfterNoon...";
		return msg;
	}

	
}
