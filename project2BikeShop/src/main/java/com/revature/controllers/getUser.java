package com.revature.controllers;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





import com.revature.beans.User;

@RestController
@RequestMapping(value="/getUser")
@CrossOrigin(origins = "*")
public class getUser {

	@GetMapping
	public User getCurr(HttpSession session){
		System.out.println("wat");
		User temp = new User();
		temp.setFname("bob");
		return temp;
		//return ((User) session.getAttribute("user"));
	}
}
