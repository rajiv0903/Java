package com.practice.nosql.gemfire.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BookOrder implements Serializable{

	private static final long serialVersionUID = 2L;
	
	private int orderNumber;
	private int customerNumber;
	private Date orderDate;
	private float orderPrice;
	private Date shipDate;
	private List<BookOrderItem> orderItems;
	
	public BookOrder() {}
	
	public BookOrder(int orderNumber, int customerNumber,  Date orderDate, float orderPrice, Date shipDate, List<BookOrderItem> orderItems) {
		super();
		this.orderNumber = orderNumber;
		this.setCustomerNumber(customerNumber);
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
		this.shipDate = shipDate;
		this.orderItems = orderItems;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public void addOrderItem(BookOrderItem orderItem) {
		orderItems.add(orderItem);
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	
	
}
