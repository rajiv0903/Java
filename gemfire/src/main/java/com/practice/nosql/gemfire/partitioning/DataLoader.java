package com.practice.nosql.gemfire.partitioning;

import java.util.ArrayList;
import java.util.Date;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

import com.practice.nosql.gemfire.model.BookOrder;
import com.practice.nosql.gemfire.model.BookOrderItem;
import com.practice.nosql.gemfire.model.Customer;
import com.practice.nosql.gemfire.model.OrderKey;
import com.practice.nosql.gemfire.util.MyCustomPdxSerializer;

public class DataLoader {

	private ClientCache cache; 
	
	public static void main(String[] args) {

		DataLoader loader = new DataLoader();
		loader.getCache();
		loader.populateCustomers();
		loader.populateBookOrders();
		loader.closeCache();
	}
	private void getCache() {
		this.cache = 
				new ClientCacheFactory()
				.setPdxSerializer(MyCustomPdxSerializer.getReflectionBasedAutoSerializer())
				.set("cache-xml-file", "clinet-cache.xml").create();
		
	}
	private void closeCache() {
		cache.close();
	}
	private void populateCustomers() {
		Region<Integer, Customer> customers = cache.getRegion("Customer");
		System.out.println("Got the customer Region: "+ customers);
		
		Customer cust1 = new Customer(1, "Rajiv" , "Chaudhuri", 34);
		cust1.addOrder(11);
		customers.put(cust1.getCustomerNumber(), cust1);
		System.out.println("Inserted a Customer: "+ cust1);
		
		Customer cust2 = new Customer(2, "Mahika" , "Chaudhuri", 1);
		customers.put(cust2.getCustomerNumber(), cust2);
		System.out.println("Inserted a Customer: "+ cust2);
		
		Customer cust3 = new Customer(3, "Tithi" , "Bose", 26);
		cust3.addOrder(13);
		customers.put(cust3.getCustomerNumber(), cust3);
		System.out.println("Inserted a Customer: "+ cust3);
		
	}
	private void populateBookOrders() {
		Region<OrderKey, BookOrder> orders = cache.getRegion("BookOrder");
		System.out.println("Got the BookOrder Region: "+ orders);
		
		OrderKey key1 = new OrderKey(1, 11);
		BookOrder order1 = new BookOrder(11, 1, new Date(), (float) 100.50, new Date(), new ArrayList<>());
		order1.addOrderItem(new BookOrderItem(1, (float)100.50 ));
		orders.put(key1, order1);
		System.out.println("Inserted a Order : "+ order1);
		
		OrderKey key2 = new OrderKey(3, 13);
		BookOrder order2 = new BookOrder(13, 3, new Date(), (float) 199.50, new Date(), new ArrayList<>());
		order2.addOrderItem(new BookOrderItem(1, (float)100.50 ));
		order2.addOrderItem(new BookOrderItem(1, (float)99.00 ));
		orders.put(key2, order2);
		System.out.println("Inserted a Order : "+ order2);
		
	}



}
