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

@CrossOrigin
@RestController
@RequestMapping(value="/login")
public class LoginController {
	//@Autowired
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
	public Boolean login(@RequestBody User login, HttpSession session) {//String username, String password, HttpSession session) {
		System.out.println("Getting log in post request");
		System.out.println(login);
		User user = userDAO.getUser(login.getUsername(), login.getPassword());
		System.out.println(user);
		if(user!=null) {
			System.out.println("sending user value");
			session.setAttribute("user", user);
			return true;
		}
		System.out.println("No user found.");
		return false;
	}
}