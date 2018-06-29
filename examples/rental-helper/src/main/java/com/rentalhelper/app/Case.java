package com.rentalhelper.app;

public class Case {
	private String id;
	private float area;
	private String type;
	private int price;
	private String owner;
	private String address;
	
	/* No parameter Constructor */
	public Case() {
	}
	
	/* All parameter Constructor */
	public Case(String id, Float area, String type, int price, String owner, String address) {
		this.id = id;
		this.area = area;
		this.type = type;
		this.price = price;
		this.owner = owner;
		this.address = address;
	}
	public void display() {
		System.out.println(this.id + "物件 - " + this.area + "坪 - " + this.type  
				+ " - 每月" + this.price + "元 - 屋主:" + this.owner  
				+ " - 地址:" + this.address);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
