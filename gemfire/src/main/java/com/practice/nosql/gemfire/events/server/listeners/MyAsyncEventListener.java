package com.practice.nosql.gemfire.events.server.listeners;

import java.util.List;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;

import com.practice.nosql.gemfire.model.BookMaster;

public class MyAsyncEventListener implements AsyncEventListener, Declarable {

	@Override
	public void close() {

	}

	@Override
	public boolean processEvents(List<AsyncEvent> events) {
		
		for(AsyncEvent<Integer, BookMaster> event: events) {
			
		}
		return true;
	}

}
