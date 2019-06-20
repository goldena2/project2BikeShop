package com.revature.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Day;
import com.revature.beans.Schedule;
import com.revature.beans.Shift;
import com.revature.data.ScheduleDOA;
import com.revature.services.GenerateSchedule;

@CrossOrigin
@RestController
public class ScheduleController {
	@Autowired
	GenerateSchedule gs;
	@Autowired
	ScheduleDOA sd;
	
	@PostMapping(value="/generateSchedule")
	public void generate(@RequestBody String[] dates){
		System.out.println(Arrays.toString(dates));
		gs.generate(dates[0], dates[1]);
	}
	
	@GetMapping(value="/schedules")
	public List<Schedule> getSchedules(){
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		scheduleList = sd.getSchedules();
		return scheduleList;
	}
	
	@PostMapping(value="/personalSchedule")
	public List<Shift> getShifts(@RequestBody Shift s){
		List<Shift> shiftList = new ArrayList<Shift>();
		System.out.println(s);
		System.out.println(s.getScheduleId());
		shiftList = sd.getShifts(s.getScheduleId(),s.getUserId());
		System.out.println(shiftList);
		return shiftList;
	}
	
	@PostMapping(value="/getDay")
	public Day getDay(@RequestBody Day d) {
		Day day = sd.getDay(d.getId());
		return day;
	}
}
