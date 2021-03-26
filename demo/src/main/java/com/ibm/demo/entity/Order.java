package com.ibm.demo.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Order {
	@NotNull
	@NotBlank
	private String item;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotNull
	private float price;
	private String id; //generated by DB as PK

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if(price<=0) {
			throw new IllegalArgumentException("Pricee cannot be negative");
		}
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
}
