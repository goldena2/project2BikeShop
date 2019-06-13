package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Product;
import com.revature.data.ProductDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class ProductHibernate implements ProductDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public boolean addProduct(Product p) {
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
			return false;
		} finally {
			s.close();
		}
		return true;
	}

	@Override
	public Product getProduct(String upc) {
		System.out.println(upc);
		Session s = hu.getSession();
		Product product;
		// in queries, you must use the Java side name, not the actual table name, 
		// so the names are case sensitive
		String query = "from Product p where p.UPC=:upc";
		Query<Product> q = s.createQuery(query, Product.class);
		q.setParameter("upc", upc);
		product = q.uniqueResult();
		return product;
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
