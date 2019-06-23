package com.revature.data;

import java.util.List;

import com.revature.beans.Shift;

public interface ShiftDAO {

	public List<Shift> getShifts(int id);

	public void deleteShift(Integer id);

	public void addShift(Shift newShift);

}
