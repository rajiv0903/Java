package com.practice.nosql.gemfire.events.client.listeners;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;

import com.practice.nosql.gemfire.model.Customer;
import com.practice.nosql.gemfire.util.MyCustomPdxSerializer;

public class ClientEventsRegisterInterestListerner {

	public static void main(String[] args) {
		ClientCache cache = 
				new ClientCacheFactory()
				.setPdxSerializer(MyCustomPdxSerializer.getReflectionBasedAutoSerializer())
				.set("cache-xml-file", "clinet-cache-registration-interest.xml").create();
		
		Region<Integer, Customer> customers = cache.getRegion("Customer");
		
		//Register
		customers.registerInterest(123);
		//all keys - special meaning
		//customers.registerInterest("ALL_KEYS");
		//regex
		//customers.registerInterestRegex("[a-zA-Z]+_[0-9]+");
		
		//Run on each sec with initial deleay of 10 ms
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("Checking content of local cache!");
				for(Customer c: customers.values()) {
					System.out.println(c);
				}
			}
		}, 10, 1000);
	}
}
