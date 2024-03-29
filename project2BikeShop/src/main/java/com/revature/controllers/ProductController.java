package com.revature.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.CreateAccountResponse;
import com.revature.beans.Invoice;
import com.revature.beans.Product;
import com.revature.beans.Sale;
import com.revature.data.ProductDAO;
import com.revature.data.SaleDAO;

@CrossOrigin
@RestController
public class ProductController {
	@Autowired
	private ProductDAO pd;
	@Autowired
	private SaleDAO sd;
	private ObjectMapper om = new ObjectMapper();
	@GetMapping(value="/products")
	public List<Product> getProducts(){
		List<Product> productList = new ArrayList<Product>();
		List<Sale> saleList = new ArrayList<Sale>();
		productList = pd.getProducts();
		saleList = sd.getSales();
		for (Product product : productList) {
			for (Sale sale : saleList) {
				if (product.getId() == sale.getProductID() & sale.getDiscount() != 0) {
					product.setPrice((round(product.getPrice()*((100 - sale.getDiscount())/100.0f),2)));
					saleList.remove(sale);
					break;
				}
			}
		}
		return productList;
	}
	
	@PostMapping(value="/products")
	public CreateAccountResponse addProduct(@RequestBody Product p) {
		System.out.println("inserting a product");
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

	@CrossOrigin
	@RequestMapping(value="/deleteProduct/{productId}", method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("productId") int id) {
		
	
		pd.deleteProduct(pd.getProduct(id));
	}
	

	@PostMapping(value="/products/createInvoice")
	public boolean createInvoice(@RequestBody Invoice invoice) {
		System.out.println("Invoice: " + invoice);
		return pd.createInvoice(invoice);
	}

	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
