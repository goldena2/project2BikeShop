package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.UserDAO;

@CrossOrigin
@RestController
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String goLogin(HttpSession session) {
		if(session.getAttribute("user")!=null) {
			System.out.println("User already logged in");
			return "redirect:home";
		}
		return "static/login.html";
	}
	

	@PostMapping
	public Boolean login(String username, String password, HttpSession session) {
		System.out.println("Getting log in post request");
		return true;
	}
}
