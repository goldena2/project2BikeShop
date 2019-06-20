package com.revature.data.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Schedule;
import com.revature.beans.Shift;
import com.revature.data.ScheduleDOA;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class ScheduleHibernate implements ScheduleDOA {
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public int createSchedule(String start, String end) {
		Schedule sched = new Schedule();
		sched.setStartDate(start);
		sched.setEndDate(end);
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(sched);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, ProductHibernate.class);
		} finally {
			s.close();
		}
		return sched.getId();
	}

	@Override
	public void createShift(Shift newShift) {
		Session s = hu.getSession();
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

	@Override
	public List<Schedule> getSchedules() {
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		Session s = hu.getSession();
		String query = "FROM Schedule";
		Query<Schedule> q = s.createQuery(query, Schedule.class);
		scheduleList = q.getResultList();
		return scheduleList;
	}

}
