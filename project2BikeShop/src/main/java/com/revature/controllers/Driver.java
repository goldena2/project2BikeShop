package com.revature.controllers;

import com.revature.beans.Product;
import com.revature.data.ProductDAO;
import com.revature.data.hibernate.ProductHibernate;

public class Driver {
	public static void main(String[] args) {
		ProductDAO pd = new ProductHibernate();
		Product p = new Product();
		p.setDescription("Example product");
		p.setName("Example part");
		p.setPrice(10.00);
		p.setStock(25);
		p.setUPC("298832593260053762");
		pd.addProduct(p);
	}
}
