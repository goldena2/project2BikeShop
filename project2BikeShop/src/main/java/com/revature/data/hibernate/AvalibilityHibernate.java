package com.revature.data.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Avalibility;
import com.revature.beans.ServiceRequest;
import com.revature.beans.User;
import com.revature.data.AvalibilityDOA;
import com.revature.utils.HibernateUtil;

@Component
public class AvalibilityHibernate implements AvalibilityDOA {
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public boolean submitAvalibility(Avalibility a) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(a);
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
	public List<Avalibility> getDayAvalibility(int day) {
		System.out.println("day " + day);
		Session s = hu.getSession();
		// in queries, you must use the Java side name, not the actual table name, 
		// so the names are case sensitive
		String query = "from Avalibility a where a.dateId = :day and a.startTime < a.endTime";
		Query<Avalibility> q = s.createQuery(query, Avalibility.class);
		q.setParameter("day", day);
		return q.list();	
	}
	
	@Override
	public void deleteUserAvalibility(Integer userId) {
		Session s = hu.getSession();
		Transaction txn = s.beginTransaction();
		// in queries, you must use the Java side name, not the actual table name, 
		// so the names are case sensitive
		String hql = "delete from Avalibility where userId= :userId";
		s.createQuery(hql).setInteger("userId", userId).executeUpdate();
		txn.commit();
	}

}
