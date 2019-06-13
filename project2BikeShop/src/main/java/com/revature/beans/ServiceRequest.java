package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="services")
public class ServiceRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="services")
	@SequenceGenerator(name="services", sequenceName="services_seq", allocationSize=1)
	private Integer id;
	@Column(name="user_id")
	private Integer userId;
}
