package com.revature.data;

import java.util.Set;

import com.revature.beans.Product;

public interface ProductDAO {
	public void addProduct(Product p);
	public Product getProduct(Integer id);
	public Set<Product> getProducts();
}
