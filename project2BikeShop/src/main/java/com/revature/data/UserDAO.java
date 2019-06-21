package com.revature.data;

import com.revature.beans.CreateAccountResponse;
import com.revature.beans.User;

public interface UserDAO {
	public User getUser(String username, String password);

	public CreateAccountResponse creatUser(User newUser);

	public User getUser(String username);
	
	public User getUser(Integer Id);
	
}
