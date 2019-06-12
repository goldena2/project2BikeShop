package com.revature.data.hibernate;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.revature.beans.Product;
import com.revature.data.ProductDAO;

public class ProductHibernate implements ProductDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public int addProduct(Product p) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(p);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, ProductHibernate.class);
		} finally {
			s.close();
		}
		return p.getId();
	}
	
}
