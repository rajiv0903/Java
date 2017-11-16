package com.practice.nosql.gemfire.runner;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;

import com.practice.nosql.gemfire.model.Customer;
import com.practice.nosql.gemfire.util.MyCustomPdxSerializer;

public class Program {

	public static void main(String[] args) {
		
		/**
		 * https://gemfire.docs.pivotal.io/geode/developing/data_serialization/auto_serialization.html
		 */
		
		//RegionShortcut 
		ClientCache clientCache = new ClientCacheFactory()
				/*.set("name", "ClientWorker")*/
				.setPdxSerializer(MyCustomPdxSerializer.getReflectionBasedAutoSerializer())
				.set("cache-xml-file", "clinet-cache.xml").create();

		Region<Integer, Customer> customers = clientCache.getRegion("Customer");
		
		Customer newCustomer = new Customer(1, "Rajiv" , "Chaudhuri", 34);
		customers.put(1, newCustomer);
		
		newCustomer = new Customer(2, "Mahika" , "Chaudhuri", 1);
		customers.put(2, newCustomer);
		
		newCustomer = new Customer(3, "Tithi" , "Bose", 26);
		customers.put(3, newCustomer);
		
		//customers.remove(1);
		Customer customer = customers.get(1);
		System.out.println(customer);
		

	}

}
