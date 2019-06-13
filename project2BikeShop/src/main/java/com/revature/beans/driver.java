package com.revature.beans;

import org.apache.log4j.Logger;

import com.revature.data.ProductDAO;
import com.revature.data.ProductOracle;

public class driver {
	private static Logger log = Logger.getLogger(ProductOracle.class);
	
	public static void main(String[] args) {
		ProductDAO pdao = new ProductOracle();
		Product prdt  = pdao.getProductById(1);
		log.trace(prdt);
		pdao.deleteProduct(prdt);
		
		
	}
	
}
