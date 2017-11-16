package com.practice.nosql.gemfire.events.server.listeners;

import java.util.Properties;

import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.util.CacheWriterAdapter;

import com.practice.nosql.gemfire.model.BookMaster;

//public class BookMasterCacheWriter implements CacheWriter<Integer, BookMaster> {

public class BookMasterCacheWriter extends CacheWriterAdapter<Integer, BookMaster> implements Declarable{

	@Override
	public void beforeCreate(EntryEvent<Integer, BookMaster> event) throws CacheWriterException {
		
		BookMaster newValue = (BookMaster) event.getNewValue();
		if(newValue.getRetailCost() < .05f) {
			throw new CacheWriterException("The book is not expenssive enough!");
		}
	}
	
	@Override
	public void beforeUpdate(EntryEvent<Integer, BookMaster> event) throws CacheWriterException {
		BookMaster newValue = (BookMaster) event.getNewValue();
		if(newValue.getRetailCost() < .05f) {
			throw new CacheWriterException("The book is not expenssive enough!");
		}
	}
	
	@Override
	public void init(Properties props) {
	}

}
