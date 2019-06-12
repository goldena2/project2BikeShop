package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.CreateAccountResponse;

@RestController
@RequestMapping(value="/createAccount")	
public class CreateAccountController {
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public CreateAccountResponse temp(HttpSession session) {
		return new CreateAccountResponse();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST)
	public CreateAccountResponse goLogin(HttpSession session,
		@RequestBody String username,
		@RequestBody String pasword) {
		System.out.println("wat");
		System.out.println(username);
		return new CreateAccountResponse();
	}
	
}
