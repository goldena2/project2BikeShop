package com.revature.data.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Day;
import com.revature.beans.Shift;
import com.revature.beans.User;
import com.revature.data.ShiftDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class ShiftHibernate implements ShiftDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public List<Shift> getShifts(int id) {
		// TODO Auto-generated method stub
		List<Shift> shiftList = new ArrayList<Shift>();
		Session se = hu.getSession(); 
		String query = "FROM Shift s where s.scheduleId=:scheduleId";
		Query<Shift> q = se.createQuery(query, Shift.class);
		q.setParameter("scheduleId", id);
		shiftList = q.getResultList();
		return shiftList;
	}

	@Override
	public void deleteShift(Integer id) {
		Session s = hu.getSession();
		Transaction txn = s.beginTransaction();
		// in queries, you must use the Java side name, not the actual table name, 
		// so the names are case sensitive
		String hql = "delete from Shift where id= :id";
		s.createQuery(hql).setParameter("id", id).executeUpdate();
		txn.commit();
	}

	@Override
	public void addShift(Shift newShift) {
		Session s = hu.getSession();
		newShift.setDay((Day) s.get(Day.class, newShift.getDay().getId()));
		newShift.setUser((User) s.get(User.class, newShift.getUser().getId()));
		System.out.println(newShift);
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(newShift);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, ProductHibernate.class);
		} finally {
			s.close();
		}
	}
	
	
}
