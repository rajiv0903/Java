package com.practice.nosql.gemfire.events.server.listeners;

import java.util.Properties;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.util.CacheListenerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practice.nosql.gemfire.model.BookMaster;

/*public class BookMasterAuditCacheListener implements CacheListener<Integer, BookMaster> {*/


public class BookMasterAuditCacheListener extends CacheListenerAdapter<Integer, BookMaster> implements 
	Declarable{
	
	private Logger logger = LogManager.getLogger(BookMasterAuditCacheListener.class.getName());
	
	@Override
	public void afterCreate(EntryEvent<Integer, BookMaster> event) {
		
		logger.info("afterCreate: Entry updated for key: "+ event.getKey() +
				"\n 		Old Value: "+ event.getOldValue() +
				"\n 		New Value: "+event.getNewValue());
	}
	@Override
	public void afterUpdate(EntryEvent<Integer, BookMaster> event) {
		
		logger.info("afterUpdate: Entry updated for key: "+ event.getKey() +
				"\n 		Old Value: "+ event.getOldValue() +
				"\n 		New Value: "+event.getNewValue());
	}
	
	@Override
	public void init(Properties props) {
	}

}
