package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product")
	@SequenceGenerator(name="product", sequenceName="product_seq", allocationSize=1)

	private Integer Id;
	private String Name;
	private String Upc;
	private Integer Price;
	private String Description;
	private Integer Stock;
	
	public Product() {
		super();
	}
	
	

	public Product(Integer id) {
		super();
		Id = id;
	}



	public Product(Integer id, String name, String upc, Integer price, String description, Integer stock) {
		super();
		Id = id;
		Name = name;
		Upc = upc;
		Price = price;
		Description = description;
		Stock = stock;
	}



	public Integer getId() {
		return Id;
	}



	public void setId(Integer id) {
		Id = id;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getUpc() {
		return Upc;
	}



	public void setUpc(String upc) {
		Upc = upc;
	}



	public Integer getPrice() {
		return Price;
	}



	public void setPrice(Integer price) {
		Price = price;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public Integer getStock() {
		return Stock;
	}



	public void setStock(Integer stock) {
		Stock = stock;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Price == null) ? 0 : Price.hashCode());
		result = prime * result + ((Stock == null) ? 0 : Stock.hashCode());
		result = prime * result + ((Upc == null) ? 0 : Upc.hashCode());
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
		Product other = (Product) obj;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Price == null) {
			if (other.Price != null)
				return false;
		} else if (!Price.equals(other.Price))
			return false;
		if (Stock == null) {
			if (other.Stock != null)
				return false;
		} else if (!Stock.equals(other.Stock))
			return false;
		if (Upc == null) {
			if (other.Upc != null)
				return false;
		} else if (!Upc.equals(other.Upc))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Product [Id=" + Id + ", Name=" + Name + ", Upc=" + Upc + ", Price=" + Price + ", Description="
				+ Description + ", Stock=" + Stock + "]";
	}

	
}
