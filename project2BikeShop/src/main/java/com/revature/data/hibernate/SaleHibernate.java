package com.revature.data.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Product;
import com.revature.beans.Sale;
import com.revature.beans.User;
import com.revature.data.SaleDAO;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class SaleHibernate implements SaleDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();
	@Override
	public boolean createSale(Sale sale) {
		System.out.println("New Discount: " +sale.getDiscount());
		Sale oldSale = getSale(sale.getProductID());
		if (oldSale != null) {
			deleteSale(oldSale);
		}else {
			System.out.println("No old sale found.");
		}

		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.saveOrUpdate(sale);;
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, SaleHibernate.class);
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
			LogUtil.logException(e, SaleHibernate.class);
			return false;
		} finally {
			s.close();
		}
		return true;
	}

	@Override
	public Sale getSale(int saleID) {
		System.out.println("saleID = " + saleID);
		Session s = hu.getSession();
		Sale sale;
		// in queries, you must use the Java side name, not the actual table name, 
		// so the names are case sensitive
		String query = "from Sale s where s.productID=:productID";
		Query<Sale> q = s.createQuery(query, Sale.class);
		q.setParameter("productID", saleID);
		sale = q.uniqueResult();
		if(sale != null) {
			System.out.println("Sale found: " + sale.getId() + " discount: " + sale.getDiscount());
		}
		return sale;
	}
	
	@Override
	public List<Sale> getSales() {
		List<Sale> salesList = new ArrayList<Sale>();
		Session s = hu.getSession();
		String query = "FROM Sale";
		Query<Sale> q = s.createQuery(query, Sale.class);
		salesList = q.getResultList();
		return salesList;
	}
}

