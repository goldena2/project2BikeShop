package com.revature.beans;

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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product")
	@SequenceGenerator(name="product", sequenceName="product_seq", allocationSize=1)
	int id;
	int productID;
	int discount;
}
