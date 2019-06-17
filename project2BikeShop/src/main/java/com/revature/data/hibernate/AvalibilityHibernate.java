package com.revature.data.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.beans.Avalibility;
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
	public List<Avalibility> getDayAvalibility(String day) {
		// TODO Auto-generated method stub
		return null;
	}

}
