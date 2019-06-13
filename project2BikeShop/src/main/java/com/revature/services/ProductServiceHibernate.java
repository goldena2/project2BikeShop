package com.revature.services;

import com.revature.beans.Product;
import com.revature.data.ProductDAO;
import com.revature.data.ProductHibernate;

public class ProductServiceHibernate implements ProductService {
	private static ProductDAO pd = new ProductHibernate();
	
	@Override
	public Product getProductById(int productId) {
		return pd.getProduct(productId);
	}

	@Override
	public void deleteProduct(Product product) {
		pd.deleteProduct(product);
		
	}

}
