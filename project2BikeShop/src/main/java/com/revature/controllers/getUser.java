package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





import com.revature.beans.User;
import com.revature.data.UserDAO;

@RestController
@CrossOrigin(origins = "*")
public class getUser {
	
	@Autowired
	private UserDAO ud;
	
	@GetMapping(value="/getUser")
	public User getCurr(HttpSession session){
		return ((User) session.getAttribute("user"));
	}
	
	@GetMapping(value="/getEmployees")
	public List<User> getEmployees(){
		return ud.getEmployees();
	}
}
