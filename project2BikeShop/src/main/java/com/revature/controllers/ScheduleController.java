package com.revature.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Product;
import com.revature.services.GenerateSchedule;

@CrossOrigin
@RestController
public class ScheduleController {
	@Autowired
	GenerateSchedule gs;
	
	@PostMapping(value="/generateSchedule")
	public void generate(@RequestBody String[] dates){
		System.out.println(Arrays.toString(dates));
		gs.generate(dates[0], dates[1]);
	}
}
