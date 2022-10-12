package com.apitesting;

import java.util.Arrays;

import org.apache.juneau.annotation.Beanc;

public class Product {
	// Today class agenda is (API)
	// How to store the data from server response data
	// How to create the data in API testing 
	// 1.	How to convert json to string 
	// 2.	How to convert string to json
	// 3.	How to convert xml to string 
	// 4.	How to convert string to xml
	// 5.	How to convert html to string 
	// 6.	How to convert string to html
	// 7.	What is the serialization
	// 8.	What is deserialization  
	// 9.	What is the pojo class 	
	
	// POJO: Plain Old Java object 
	
	private String color;
	private int price;
	private String name;


	private String[] sellerNames;
	
	@Beanc(properties = "color, price, name, sellerNames")
	public Product(String color, int price, String name, String[] sellerNames) {
		this.color = color;
		this.price = price;
		this.name = name;
		this.sellerNames = sellerNames;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getSellerNames() {
		return sellerNames;
	}

	public void setSellerNames(String[] sellerNames) {
		this.sellerNames = sellerNames;
	}
	@Override
	public String toString() {
		return "Product [color=" + color + ", price=" + price + ", name=" + name + ", sellerNames="
				+ Arrays.toString(sellerNames) + "]";
	}
	
}
