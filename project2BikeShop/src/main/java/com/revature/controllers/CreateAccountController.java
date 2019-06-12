package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.CreateAccountResponse;
import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.data.hibernate.UserHibernate;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/createAccount")	
public class CreateAccountController {
	private UserDAO ud = new UserHibernate();
	
	@GetMapping
	public CreateAccountResponse temp(HttpSession session) {
		return new CreateAccountResponse();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public CreateAccountResponse goLogin(HttpSession session,
		@RequestBody User newUser) {
		CreateAccountResponse status = new CreateAccountResponse();
		status.setSuccess(ud.creatUser(newUser));
		return status;
		
	}
	
}
