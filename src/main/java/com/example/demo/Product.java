package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String description;
	String manufacturer;
	boolean active;
	float price;
	public Product(String name, String description, String manufacturer, boolean active, float price) {
		super();
		this.name = name;
		this.description = description;
		this.manufacturer = manufacturer;
		this.active = active;
		this.price=price;
	}
	
}
