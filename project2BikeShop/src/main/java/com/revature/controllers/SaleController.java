package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Sale;
import com.revature.data.SaleDAO;

@CrossOrigin
@RestController
public class SaleController {
	@Autowired
	private SaleDAO sd;
	private ObjectMapper om = new ObjectMapper();
	
	@PostMapping(value="/createSale")
	public void createSale(@RequestBody Sale sale) {
		sd.createSale(sale);
	}
	
	@GetMapping(value="/getSales")
	public List<Sale> getSales(){
		List<Sale> salesList = new ArrayList<Sale>();
		salesList = sd.getSales();
		return salesList;
	}
	
	@DeleteMapping(value="/deleteSale")
	public void deleteSale(@RequestBody int productID) {
		
	}
}

