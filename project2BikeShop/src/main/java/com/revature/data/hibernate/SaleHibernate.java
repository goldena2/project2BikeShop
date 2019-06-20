package com.revature.data.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Product;
import com.revature.beans.Sale;
import com.revature.data.SaleDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class SaleHibernate implements SaleDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public boolean createSale(Sale sale) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(sale);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, ProductHibernate.class);
			return false;
		} finally {
			s.close();
		}
		return true;
	}

	@Override
	public boolean deleteSale(Sale sale) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(sale);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, ProductHibernate.class);
			return false;
		} finally {
			s.close();
		}
		return true;
	}

}
