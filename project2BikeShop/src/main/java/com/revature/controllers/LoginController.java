package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
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
	//@Autowired
	//private UserDAO userDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String goLogin(HttpSession session) {
		if(session.getAttribute("user")!=null) {
			System.out.println("User already logged in");
			return "redirect:home";
		}
		return "static/login.html";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(HttpSession session) {//String username, String password, HttpSession session) {
		
		System.out.println("Getting log in post request");
		return "redirect:home";
	}
}
