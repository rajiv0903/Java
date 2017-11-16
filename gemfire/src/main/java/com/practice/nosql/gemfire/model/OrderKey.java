package com.practice.nosql.gemfire.model;

import java.io.Serializable;

/**
 * @author rajiv
 * Custom key that makes it possible to manage the key that will ensure uniqueness 
 * within BookOrder region as well as alignment between the Customer and BookOrder 
 * region data
 */
public class OrderKey implements Serializable{

	private static final long serialVersionUID = 4;
	
	private Integer customerNumber;
	private Integer orderNumber;
	
	public OrderKey() {}
	
	public OrderKey(Integer customerNumber, Integer orderNumber) {
		this.setOrderNumber(orderNumber);
		this.customerNumber = customerNumber;
	}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderKey other = (OrderKey) obj;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		return true;
	}
	
	
}
