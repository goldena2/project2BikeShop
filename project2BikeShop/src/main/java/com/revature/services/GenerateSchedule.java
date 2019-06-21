package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Avalibility;
import com.revature.beans.Shift;
import com.revature.data.AvalibilityDOA;
import com.revature.data.ScheduleDOA;
import com.revature.data.UserDAO;

@Component
public class GenerateSchedule {

	@Autowired
	AvalibilityDOA ad;
	@Autowired
	ScheduleDOA sd;
	@Autowired
	UserDAO ud;
	
	public void generate(String start, String end) {
		int id = sd.createSchedule(start, end);
		for(int i = 1; i <= 5; i++) {
			generateDaySchedule(ad.getDayAvalibility(i), id);
		}
	}
	private void generateDaySchedule(List<Avalibility> dayAvalibility, int id) {
		
		final int dayStart = 480;
		final int dayEnd = 990;
		int currTime = dayStart;
		
		while(dayAvalibility.size() > 0 && currTime < dayEnd) {
			int index = findFirstperson(dayAvalibility, currTime);
			if(index > -1) {
				createShift(currTime, dayAvalibility.get(index), id);
				currTime = dayAvalibility.get(index).getEndTime();
				dayAvalibility.remove(index);
			}else {
				currTime += 15;
			}
		}
	}
	
	private void createShift(int currTime, Avalibility avalibility, int id) {
		Shift newShift = new Shift();
		newShift.setUser(ud.getUser(avalibility.getUserId()));
		newShift.setStartTime(currTime);
		newShift.setEndTime(avalibility.getEndTime());
		newShift.setScheduleId(id);
		newShift.setDay(sd.getDay(avalibility.getDateId()));
		//newShift.setDateId(avalibility.getDateId());
		sd.createShift(newShift);
	}
	
	private int findFirstperson(List<Avalibility> dayAvalibility, int currTime) {
		for(int i = 0; i < dayAvalibility.size(); i++) {
			if(dayAvalibility.get(i).getStartTime() == currTime) {
				return i;
			}
		}
		return findMiddle(dayAvalibility, currTime);
	}
	private int findMiddle(List<Avalibility> dayAvalibility, int currTime) {
		for(int i = 0; i < dayAvalibility.size(); i++) {
			if(dayAvalibility.get(i).getStartTime() <= currTime && 
				dayAvalibility.get(i).getEndTime() > currTime) {
				return i;
			}
		}
		return -1;
	}
	

}
