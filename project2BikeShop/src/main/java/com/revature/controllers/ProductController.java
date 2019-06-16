package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.CreateAccountResponse;
import com.revature.beans.Invoice;
import com.revature.beans.Product;
import com.revature.data.ProductDAO;

@CrossOrigin
@RestController
public class ProductController {
	@Autowired
	private ProductDAO pd;
	private ObjectMapper om = new ObjectMapper();
	@GetMapping(value="/products")
	public List<Product> getProducts(){
		List<Product> productList = new ArrayList<Product>();
		productList = pd.getProducts();
		return productList;
	}
	
	@PostMapping(value="/products")
	public CreateAccountResponse addProduct(@RequestBody Product p) {
		System.out.println(p);
		CreateAccountResponse status = new CreateAccountResponse();
		status.setSuccess(pd.addProduct(p));
		return status;
	}
	
	@PostMapping(value="/products/makePurchase")
	public void updateStock(@RequestBody Product product, HttpSession session) {
		System.out.println(product);
		
		pd.updateStock(product);
	}
	@PostMapping(value="/products/createInvoice")
	public boolean createInvoice(@RequestBody Invoice invoice) {
		System.out.println("Invoice: " + invoice);
		return pd.createInvoice(invoice);
	}
}
