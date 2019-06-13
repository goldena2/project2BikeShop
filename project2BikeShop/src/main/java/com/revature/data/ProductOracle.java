package com.revature.data;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.revature.utils.ConnectionUtil;
import com.revature.utils.LogUtil;
import com.revature.beans.Product;

public class ProductOracle implements ProductDAO {
	
	private static Logger log = Logger.getLogger(ProductOracle.class);
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	@Override
	public Product getProductById(int productId) {
		log.trace("Retrieving product from database");
		Product p = new Product();
		
		try (Connection conn = cu.getConnection()) {
			String sql = "select * from product where id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, productId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				log.trace("Product found.");
				p.setId(rs.getInt(productId));
				p.setName(rs.getString("name"));
				p.setUpc(rs.getString("upc"));
				p.setPrice(rs.getInt("price"));
				p.setDescription("description");
				p.setStock(rs.getInt("stock"));
				
				
			}
		} catch (Exception e) {
			LogUtil.logException(e, ProductOracle.class);
		}
		
		return p;
	}


	@Override
	public void deleteProduct(Product product) {
		log.trace("Removing product from database.");
		try(Connection conn = cu.getConnection()){
			conn.setAutoCommit(false);
			String sql = "delete from product where Id = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, product.getId());
			int number = pstm.executeUpdate();
			if(number != 1) {
				log.trace("Product not deleted");
				conn.rollback();
			} else {
				log.trace("Product deleted");
				conn.commit();
			}
		} catch (Exception e) {
			LogUtil.logException(e, ProductOracle.class);
		}
	}

}
