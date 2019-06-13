package com.revature.beans;

import com.revature.data.ProductDAO;
import com.revature.data.ProductOracle;

public class driver {

	
	public static void main(String[] args) {
		ProductDAO pdao = new ProductOracle();
		Product prdt  = pdao.getProductById(0);
		pdao.deleteProduct(prdt);
		
		
	}
	
}
