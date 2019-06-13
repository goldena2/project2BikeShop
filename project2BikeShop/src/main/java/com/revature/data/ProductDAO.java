package com.revature.data;

import java.util.Set;

import com.revature.beans.Product;

public interface ProductDAO {
	
	public void deleteProduct(Product product);
	public boolean addProduct(Product p);
	public Set<Product> getProducts();
	public Product getProduct(String upc);
}
