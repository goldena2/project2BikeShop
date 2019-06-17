package com.revature.data.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.CreateAccountResponse;
import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.utils.HibernateUtil;

@Component
public class UserHibernate implements UserDAO {
	private static HibernateUtil hu = HibernateUtil.getInstance();
	
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
	
	@Override
	public User getUser(String username) {
		Session s = hu.getSession();
		User user;
		// in queries, you must use the Java side name, not the actual table name, 
		// so the names are case sensitive
		String query = "from User u where u.username=:username";
		Query<User> q = s.createQuery(query, User.class);
		q.setParameter("username", username);
		user = q.uniqueResult();
		return user;
	}


	@Override
	public CreateAccountResponse creatUser(User newUser) {
		CreateAccountResponse resp = new CreateAccountResponse();

		if(getUser(newUser.getUsername()) != null) {
			resp.setSuccess(false);
			resp.setMessage("Username Already in use");
			return resp;
		}
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(newUser);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			resp.setSuccess(false);
			resp.setMessage("Failed to create acount");
		} finally {
			s.close();
		}
		return resp;
	}
}
