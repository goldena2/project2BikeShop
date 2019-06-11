package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.User;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	//@Autowired
	
	@RequestMapping(method=RequestMethod.GET)
	public String goLogin(HttpSession session) {
		if(session.getAttribute("user")!=null) {
			return "redirect:home";
		}
		return "static/login.html";
	}
	
	@PostMapping
	public String login() {//String username, String password, HttpSession session) {
		System.out.println("wat");
		return "redirect:home";
	}
}
