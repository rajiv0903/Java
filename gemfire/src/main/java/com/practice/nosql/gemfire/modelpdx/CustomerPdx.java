package com.practice.nosql.gemfire.modelpdx;


import java.util.ArrayList;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class CustomerPdx implements PdxSerializable{


	private Integer customerNumber;
	private String firstName;
	private String lastName;
	private AddressPdx primaryAddress;
	private ArrayList<Integer> myBookOrders = new ArrayList<>();
	
	//Default constructor is required for PDX and Reflection Based 
	public CustomerPdx() {}
	
	public CustomerPdx(int customerNumber, String firstName, String lastName) {
		super();
		this.customerNumber = new Integer(customerNumber);
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	public CustomerPdx(int customerNumber, String firstName, String lastName, String postalCode) {
		super();
		this.customerNumber = new Integer(customerNumber);
		this.firstName = firstName;
		this.lastName = lastName;
		this.primaryAddress = new AddressPdx(postalCode);
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

	public AddressPdx getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(AddressPdx primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public ArrayList<Integer> getMyBookOrders() {
		return myBookOrders;
	}

	public void setMyBookOrders(ArrayList<Integer> myBookOrders) {
		this.myBookOrders = myBookOrders;
	}

	@Override
	public String toString() {
		return "CustomerPdx [customerNumber=" + customerNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", primaryAddress=" + primaryAddress + ", myBookOrders=" + myBookOrders + "]";
	}

	@Override
	public void toData(PdxWriter writer) {
		writer.writeInt("customerNumber", customerNumber);
		writer.markIdentityField("customerNumber");
		writer.writeString("firstName", firstName);
		writer.writeField("primaryAddress", primaryAddress, AddressPdx.class);
		writer.writeField("myBookOrders", myBookOrders, ArrayList.class);
		
	}

	@Override
	public void fromData(PdxReader reader) {
		
		customerNumber= reader.readInt("customerNumber");
		firstName = reader.readString("firstName");
		primaryAddress = (AddressPdx) reader.readField("primaryAddress");
		myBookOrders = (ArrayList<Integer>) reader.readField("myBookOrders");
	}
	
	
	
}
