package com.practice.nosql.gemfire.model;

import java.io.Serializable;

public class BookOrderItem implements Serializable{
	
	private static final long serialVersionUID = 3L;
	
	private int bookid;
	private float price;
	
	public BookOrderItem() {
	}
	
	public BookOrderItem(int bookid, float price) {
		super();
		this.bookid = bookid;
		this.price = price;
	}

	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	

}
