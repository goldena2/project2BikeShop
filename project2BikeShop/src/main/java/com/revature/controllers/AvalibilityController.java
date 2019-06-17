package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Avalibility;
import com.revature.data.AvalibilityDOA;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/submitAvalibility")	
public class AvalibilityController {
	
	@Autowired
	AvalibilityDOA ad;
	@PostMapping
	public void submit(@RequestBody Avalibility newAvalibilty) {
		ad.submitAvalibility(newAvalibilty);
	}
}
