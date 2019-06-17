package com.revature.data;

import java.util.List;

import com.revature.beans.Invoice;
import com.revature.beans.Product;



public interface ProductDAO {
	
	
	public boolean addProduct(Product p);
	public Product getProduct(int id);
	public void deleteProduct(Product product);
	
	public List<Product> getProducts();
	public void updateStock(Product product);
	public boolean createInvoice(Invoice invoice);
}
