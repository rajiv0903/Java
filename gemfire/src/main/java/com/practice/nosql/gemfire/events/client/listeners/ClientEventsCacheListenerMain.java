package com.practice.nosql.gemfire.events.client.listeners;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;

import com.practice.nosql.gemfire.model.Customer;
import com.practice.nosql.gemfire.util.MyCustomPdxSerializer;

public class ClientEventsCacheListenerMain {

	/**
	 * @param args
	 * @throws Exception
	 * Run this program to register events
	 */
	public static void main(String[] args) throws Exception {
		ClientCache cache = new ClientCacheFactory()
				.setPdxSerializer(MyCustomPdxSerializer.getReflectionBasedAutoSerializer())
				.set("cache-xml-file", "clinet-cache-cache-listener.xml").create();

		Region<Integer, Customer> customers = cache.getRegion("Customer");

		customers.registerInterest(1235678);
		//to keep on 
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				//System.out.println("Running!");
			}
		}, 10, 3000);
	}
}
