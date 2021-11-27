package com.manufacture.entity;

public class Bicycle {
	private String item;
	private int count1;

	public Bicycle() {
		// TODO Auto-generated constructor stub
	}

	public Bicycle(String item, int count1) {
		super();
		this.item = item;
		this.count1 = count1;
	}

	public Bicycle(String item) {
		this.item = item;
		// TODO Auto-generated constructor stub
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getCount1() {
		return count1;
	}

	public void setCount1(int count1) {
		this.count1 = count1;
	}

}
