package com.practice.nosql.gemfire.events.client;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;

import com.practice.nosql.gemfire.model.Customer;
import com.practice.nosql.gemfire.util.MyCustomPdxSerializer;

public class ClientEventsRegisterInterestLoader {

	public static void main(String[] args) {

		ClientCache cache = new ClientCacheFactory()
				.setPdxSerializer(MyCustomPdxSerializer.getReflectionBasedAutoSerializer())
				.set("cache-xml-file", "clinet-cache2.xml").create();

		Region<Integer, Customer> customers = cache.getRegion("Customer");

		int key = 123;
		Customer customer = new Customer(key, "Rajiv", "Chaudhuri", 34);
		customers.put(key, customer);
	}
}
