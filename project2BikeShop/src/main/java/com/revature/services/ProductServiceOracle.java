package com.revature.services;

import org.apache.log4j.Logger;

import com.revature.beans.Product;
import com.revature.data.ProductDAO;
import com.revature.data.ProductOracle;



public class ProductServiceOracle implements ProductService{
	private Logger log = Logger.getLogger(ProductServiceOracle.class);
	private ProductDAO pd = new ProductOracle();
	
	@Override
	public void deleteProduct(Product product) {
		pd.deleteProduct(product);
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
