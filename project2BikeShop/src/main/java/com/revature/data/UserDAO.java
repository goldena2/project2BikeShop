package com.revature.data;

import com.revature.beans.User;

public interface UserDAO {
	public User getUser(String username, String password);
	
}
