package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.ServiceRequest;
import com.revature.data.ServicesDOA;
import com.revature.data.UserDAO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/services")	
public class ServiceScheduleController {

	@Autowired
	private ServicesDOA sd;
	
	
	
	@PostMapping
	public Boolean scheduleService(@RequestBody ServiceRequest req) {
		System.out.println(req);
		return sd.addService(req);
	}
	
	@GetMapping
	public List<ServiceRequest> getGenre() {
		int userId = 1;
		return sd.getMyRequest(userId);
	}
	
}
