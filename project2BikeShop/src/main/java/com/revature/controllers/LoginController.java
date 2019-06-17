package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.data.UserDAO;

@CrossOrigin
@RestController
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping(value="/hi")
	public String hi() {
		return "Hello";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String goLogin(@RequestBody User newUser, HttpSession session) {
		User user = userDAO.getUser(newUser.getUsername(), newUser.getPassword());
		if(session.getAttribute("user")!=null) {
			session.setAttribute("user_id", user.getId());
			System.out.println("User already logged in");
			return "redirect:home";
		}
		System.out.println("Log in");
		return "static/login.html";
	}
	
	@PostMapping
	public User login(@RequestBody User newUser, HttpSession session) {
		System.out.println(newUser);
		System.out.println(newUser.getPassword());

		User user = userDAO.getUser(newUser.getUsername(), newUser.getPassword());
		if(user != null) {
			session.setAttribute("user", user);
			return user;
		}
		else {
			System.out.println("no user found.");
		}
		return user;
	}
}
