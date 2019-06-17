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
public class AvalibilityController {
	
	@Autowired
	AvalibilityDOA ad;
	
	@PostMapping(value="/submitAvalibility")
	public void submit(@RequestBody Avalibility newAvalibilty) {
		ad.submitAvalibility(newAvalibilty);
	}
	
	@PostMapping(value="/deleteAvalibility")
	public void deleteOldValues(@RequestBody Integer userId) {
		ad.deleteUserAvalibility(userId);
	}
}
