package com.revature.data.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Product;
import com.revature.data.ProductDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

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
