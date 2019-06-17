package com.revature.data;

import java.util.List;

import com.revature.beans.Avalibility;

public interface AvalibilityDOA {
	public boolean submitAvalibility(Avalibility a);
	public List<Avalibility> getDayAvalibility(String day);
}
