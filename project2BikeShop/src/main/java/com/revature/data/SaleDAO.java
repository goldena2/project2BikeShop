package com.revature.data;

import java.util.List;

import com.revature.beans.Sale;

public interface SaleDAO {
	public boolean createSale(Sale sale);
	public boolean deleteSale(Sale sale);
	public Sale getSale(int saleID);
	public List<Sale> getSales();
}
