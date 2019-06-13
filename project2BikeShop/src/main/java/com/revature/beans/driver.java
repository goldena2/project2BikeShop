package com.revature.beans;

import org.apache.log4j.Logger;

import com.revature.data.ProductDAO;
import com.revature.data.ProductOracle;
import com.revature.services.ProductService;
import com.revature.services.ProductServiceHibernate;

public class driver {
	private static Logger log = Logger.getLogger(ProductOracle.class);
	
	public static void main(String[] args) {
		ProductService pdao = new ProductServiceHibernate();
//		Product prdt  = pdao.getProduct("123423");
//		log.trace(prdt);
//		pdao.deleteProduct(prdt);
//		
		
	}
	
}
