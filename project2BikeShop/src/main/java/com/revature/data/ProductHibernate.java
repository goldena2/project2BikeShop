package com.revature.data;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Product;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class ProductHibernate implements ProductDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();
	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Product product) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(product);
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
	
	
	

