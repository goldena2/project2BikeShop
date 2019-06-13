package com.revature.data;

import com.revature.beans.Product;

public interface ProductDAO {
	
	public Product getProduct(int productId);
	
	public void deleteProduct(Product product);
}
