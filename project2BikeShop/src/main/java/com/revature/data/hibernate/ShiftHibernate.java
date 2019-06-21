package com.revature.data.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Shift;
import com.revature.data.ShiftDAO;
import com.revature.utils.HibernateUtil;

@Component
public class ShiftHibernate implements ShiftDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public List<Shift> getShifts(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		List<Shift> shiftList = new ArrayList<Shift>();
		Session se = hu.getSession(); 
		String query = "FROM Shift s where s.scheduleId=:scheduleId";
		Query<Shift> q = se.createQuery(query, Shift.class);
		q.setParameter("scheduleId", id);
		shiftList = q.getResultList();
		return shiftList;
	}
	
	
}
