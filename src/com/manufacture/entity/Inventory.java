package com.manufacture.entity;

public class Inventory {
	private String item;
	private int stock;

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(String item, int stock) {
		super();
		this.item = item;
		this.stock = stock;
	}

	public Inventory(String item) {
		this.item=item;
		
	}
  
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
