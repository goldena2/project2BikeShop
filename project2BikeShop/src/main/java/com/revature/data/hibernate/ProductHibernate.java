package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Product;
import com.revature.data.ProductDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class ProductHibernate implements ProductDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public void addProduct(Product p) {
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
	}

	@Override
	public Product getProduct(Integer id) {
		Product p;
		Session s = hu.getSession();
		p = s.get(Product.class, id);
		s.close();
		return p;
	}

	@Override
	public Set<Product> getProducts() {
		Session s = hu.getSession();
		String query = "FROM Product";
		Query<Product> q = s.createQuery(query, Product.class);
		List<Product> productList = q.getResultList();
		Set<Product> productSet = new HashSet<Product>();
		productSet.addAll(productList);
		return productSet;
	}
	
	
	
}
