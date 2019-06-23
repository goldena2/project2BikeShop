package com.revature.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Product;
import com.revature.beans.Schedule;
import com.revature.beans.Shift;
import com.revature.data.ScheduleDOA;
import com.revature.data.ShiftDAO;
import com.revature.beans.Day;


import com.revature.services.GenerateSchedule;

@CrossOrigin
@RestController
public class ScheduleController {
	@Autowired
	GenerateSchedule gs;
	@Autowired
	private ScheduleDOA sd;
	@Autowired
	private ShiftDAO shd;
	private ObjectMapper om = new ObjectMapper();
	
	@GetMapping(value="/schedules/{scheduleId}")
	public List<Shift> getShifts(@PathVariable("scheduleId")int id){
		List<Shift> shiftList = new ArrayList<Shift>();
		shiftList = shd.getShifts(id);
		return shiftList;
	}
	

	@PostMapping(value="/generateSchedule")
	public void generate(@RequestBody String[] dates){
		System.out.println(Arrays.toString(dates));
		gs.generate(dates[0], dates[1]);
	}
	
	@PostMapping(value="/schedules/deleteShift")
	public void deleteShift(@RequestBody Integer id) {
		shd.deleteShift(id);
	}
	
	@PostMapping(value="/schedules/addShift")
	public void removeShift(@RequestBody Shift newShift) {
		System.out.println(newShift);
		shd.addShift(newShift);
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
		shiftList = sd.getShifts(s.getScheduleId(),s.getUser().getId());
		System.out.println(shiftList);
		return shiftList;
	}
	
	@PostMapping(value="/getDay")
	public Day getDay(@RequestBody Day d) {
		Day day = sd.getDay(d.getId());
		return day;
	}
}
