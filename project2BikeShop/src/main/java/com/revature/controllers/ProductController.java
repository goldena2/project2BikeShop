package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.CreateAccountResponse;
import com.revature.beans.Product;
import com.revature.data.ProductDAO;

@CrossOrigin
@RestController
@RequestMapping(value="/products")
public class ProductController {
	@Autowired
	private ProductDAO pd;
	
	@GetMapping
	public List<Product> getProducts(){
		List<Product> productList = new ArrayList<Product>();
		productList = pd.getProducts();
		return productList;
	}
	
	@PostMapping
	public CreateAccountResponse addProduct(@RequestBody Product p) {
		CreateAccountResponse status = new CreateAccountResponse();
		status.setSuccess(pd.addProduct(p));
		return status;
	}
}
