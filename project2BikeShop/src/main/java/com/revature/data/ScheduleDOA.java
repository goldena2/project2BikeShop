package com.revature.data;

import com.revature.beans.Shift;

public interface ScheduleDOA {
	public int createSchedule(String start, String end);
	public void createShift(Shift newShift);
}
