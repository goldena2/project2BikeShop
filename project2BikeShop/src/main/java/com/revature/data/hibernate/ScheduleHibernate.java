package com.revature.data.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Day;
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

	@Override
	public List<Shift> getShifts(Integer scheduleId, Integer userId) {
		List<Shift> shiftList = new ArrayList<Shift>();
		Session s = hu.getSession();
		String query = "FROM Shift s where s.scheduleId =:scheduleId and s.userId =:userId";
		Query<Shift> q = s.createQuery(query, Shift.class);
		q.setParameter("scheduleId", scheduleId);
		q.setParameter("userId", userId);
		shiftList = q.getResultList();
		return shiftList;
	}

	@Override
	public Day getDay(Integer id) {
		Day d;
		Session s = hu.getSession();
		String query = "from Day d where d.id =:id";
		Query<Day> q = s.createQuery(query, Day.class);
		q.setParameter("id", id);
		d = q.uniqueResult();
		return d;
	}

}
