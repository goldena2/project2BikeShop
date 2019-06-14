package com.revature.data.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.ServiceRequest;
import com.revature.beans.User;
import com.revature.data.ServicesDOA;
import com.revature.utils.HibernateUtil;

@Component
public class ServiceHibernate implements ServicesDOA {

	private static HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public boolean addService(ServiceRequest req) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(req);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			s.close();
		}
	}


	@Override
	public List<ServiceRequest> getMyRequest(Integer userId) {
		Session s = hu.getSession();
		User user;
		// in queries, you must use the Java side name, not the actual table name, 
		// so the names are case sensitive
		String query = "from ServiceRequest u";
		Query<ServiceRequest> q = s.createQuery(query, ServiceRequest.class);
		return q.list();
	}

}
