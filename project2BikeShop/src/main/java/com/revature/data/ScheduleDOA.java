package com.revature.data;

import java.util.List;

import com.revature.beans.Schedule;
import com.revature.beans.Shift;

public interface ScheduleDOA {
	public int createSchedule(String start, String end);
	public void createShift(Shift newShift);
	
	public List<Schedule> getSchedules();
}
