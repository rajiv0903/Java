package com.practice.nosql.gemfire.modelpdx;

import java.util.ArrayList;

public class Customer{

	private Integer customerNumber;
	private String firstName;
	private String lastName;
	private Address primaryAddress;
	private ArrayList<Integer> myBookOrders = new ArrayList<>();
	private ArrayList<String> nickNames = new ArrayList<>();
	
	//Default constructor is required for PDX and Reflection Based 
	public Customer() {}
	
	public Customer(int customerNumber, String firstName, String lastName) {
		super();
		this.customerNumber = new Integer(customerNumber);
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	public Customer(int customerNumber, String firstName, String lastName, String postalCode) {
		super();
		this.customerNumber = new Integer(customerNumber);
		this.firstName = firstName;
		this.lastName = lastName;
		this.primaryAddress = new Address(postalCode);
	}
	
	public void addOrder(int orderNumber) {
		myBookOrders.add(orderNumber);
	}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
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

	public Address getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(Address primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public ArrayList<Integer> getMyBookOrders() {
		return myBookOrders;
	}

	public void setMyBookOrders(ArrayList<Integer> myBookOrders) {
		this.myBookOrders = myBookOrders;
	}

	public ArrayList<String> getNickNames() {
		return nickNames;
	}

	public void setNickNames(ArrayList<String> nickNames) {
		this.nickNames = nickNames;
	}

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", primaryAddress=" + primaryAddress + ", myBookOrders=" + myBookOrders + ", nickNames=" + nickNames
				+ "]";
	}

	

	
	
}
