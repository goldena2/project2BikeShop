package com.revature.data;

import java.util.Set;

import com.revature.beans.Product;

public interface ProductDAO {
	
	
	public boolean addProduct(Product p);
	public Product getProduct(String upc);
	public Set<Product> getProducts();
	public void deleteProduct(Product product);
	
}
