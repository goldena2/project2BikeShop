package com.revature.data.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.utils.HibernateUtil;

public class UserHibernate implements UserDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public User getUser(String username, String password) {
		Session s = hu.getSession();
		User user;
		// in queries, you must use the Java side name, not the actual table name, 
		// so the names are case sensitive
		String query = "from User u where u.username=:username and u.password=:password";
		Query<User> q = s.createQuery(query, User.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		user = q.uniqueResult();
		return user;
	}
}