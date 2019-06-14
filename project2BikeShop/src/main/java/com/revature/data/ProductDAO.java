package com.revature.data;

import java.util.List;

import com.revature.beans.Product;



public interface ProductDAO {
	
	
	public boolean addProduct(Product p);
	public Product getProduct(String upc);
	public void deleteProduct(Product product);
	
	public List<Product> getProducts();
}
