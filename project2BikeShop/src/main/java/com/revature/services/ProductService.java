package com.revature.services;

import com.revature.beans.Product;

public interface ProductService {
	public Product getProductById(int productId);
	
	public void deleteProduct(Product product);
}
