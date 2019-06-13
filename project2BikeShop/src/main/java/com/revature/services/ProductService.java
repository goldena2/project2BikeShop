package com.revature.services;

import com.revature.beans.Product;

public interface ProductService {
	public Product getProduct(int upc);
	
	public void deleteProduct(Product product);
}
