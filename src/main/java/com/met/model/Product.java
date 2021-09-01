package com.met.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="producttbl")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pno;
	private float price;
	private int stock;
	
	
	
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Product [pno=" + pno + ", price=" + price + ", stock=" + stock + "]";
	}
	
	
	
	

	
	
}
