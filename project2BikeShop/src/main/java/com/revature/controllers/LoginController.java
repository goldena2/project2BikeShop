package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.data.UserDAO;

@CrossOrigin//(origins="*")
@RestController
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String goLogin(@RequestBody User newUser, HttpSession session) {
		System.out.println(userDAO.getUser(newUser.getUsername(), newUser.getPassword()));
		if(session.getAttribute("user")!=null) {
			System.out.println("User already logged in");
			return "redirect:home";
		}
		return "static/login.html";
	}
	
	@PostMapping
	public User login(@RequestBody User newUser, HttpSession session) {
		System.out.println(newUser);
		User user = userDAO.getUser(newUser.getUsername(), newUser.getPassword());
		if(user != null) {
			session.setAttribute("user", user);
			return user;
		}
		return user;
	}
}
