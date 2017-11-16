package com.practice.nosql.gemfire.model;

import java.io.Serializable;

public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int customerNumber;
	private String firstName;
	private String lastName;
	private int age;
	private int orderNumber;
	
	public Customer() {}
	
	public Customer(int customerNumber, String firstName, String lastName, int age) {
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public void addOrder(int orderNumber) {
		this.setOrderNumber(orderNumber);
	}


	public int getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + "]";
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}



	
	
	
	
	
	

}
