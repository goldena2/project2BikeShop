package com.revature.controllers;

import javax.servlet.http.HttpSession;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
=======
>>>>>>> 195defa54c3e7799cd539f57fbc2e39ad63aa6e6
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
	

	@PostMapping
	public String login(String username, String password, HttpSession session) {//String username, String password, HttpSession session) {
		System.out.println("Getting log in post request");
		return "redirect:home";
	}
}
