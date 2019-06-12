package com.revature.services;

import com.revature.beans.User;

public interface UserService {
	public User getUser(String username, String password);
}
