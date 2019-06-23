package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sales")
public class Sale {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sale")
	@SequenceGenerator(name="sale", sequenceName="sales_seq", allocationSize=1)
	int id;
	@Column(name="product_id")
	int productID;
	@Column(name="sale")
	int discount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + discount;
		result = prime * result + id;
		result = prime * result + productID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (discount != other.discount)
			return false;
		if (id != other.id)
			return false;
		if (productID != other.productID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sale [id=" + id + ", productID=" + productID + ", discount=" + discount + "]";
	}
}
