package com.revature.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Product;
import com.revature.data.ProductDAO;

@RestController
@RequestMapping(value="/products")
public class ProductController {
	private ProductDAO pd;
	
	@PostMapping
	public String addProduct(@RequestBody Product p) {
		Integer i = pd.addProduct(p);
		return "Success";
	}
}
