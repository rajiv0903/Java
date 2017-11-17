package com.practice.nosql.gemfire.events.client.listeners;

import java.util.Properties;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.util.CacheListenerAdapter;

public class ClientEventsCacheListener extends CacheListenerAdapter implements Declarable{

	@Override
	public void afterCreate(EntryEvent event) {
		System.out.println("Key: "+event.getKey());
		System.out.println("New Value: "+event.getNewValue());
		
		//Automatically register interest on any entries created locally 
		event.getRegion().registerInterest(event.getKey());
	}
	
	@Override
	public void afterUpdate(EntryEvent event) {
		System.out.println("Key: "+event.getKey());
		System.out.println("Old Value: "+event.getOldValue());
		System.out.println("New Value: "+event.getNewValue());
	}
	
	@Override
	public void init(Properties props) {
	}
}
