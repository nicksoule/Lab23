package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // marks the class as a hibernate entity
@Table(name = "Items") // maps the class to the DB table specified by the name modifier
public class Items {
	private String name;
	private String description;
	private int quantity;
	private double price;

	public Items() {

	}

	public Items(String name, String description, int quantity, double price) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Id // maps the primary key
	 // instructs the DB to generate a value for the field automatically
	@Column(name = "Name") // name is optional if column name matches variable name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String descript) {
		this.description = descript;
	}
	
	@Column(name = "Quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Column(name = "Price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return "primary key assigned as 0 is assigning the value of null to the productID: " + 
	name + "," + description + "," + quantity + "," + price;
	}

}
