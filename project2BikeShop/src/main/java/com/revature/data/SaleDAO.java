package com.revature.data;

import com.revature.beans.Sale;

public interface SaleDAO {
	public boolean createSale(Sale sale);
	public boolean deleteSale(Sale sale);
}
