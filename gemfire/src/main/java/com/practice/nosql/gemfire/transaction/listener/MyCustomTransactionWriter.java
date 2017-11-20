package com.practice.nosql.gemfire.transaction.listener;

import org.apache.geode.cache.TransactionEvent;
import org.apache.geode.cache.TransactionWriter;
import org.apache.geode.cache.TransactionWriterException;

public class MyCustomTransactionWriter implements TransactionWriter{

	@Override
	public void close() {
		
	}

	@Override
	public void beforeCommit(TransactionEvent event) throws TransactionWriterException {
		System.out.println(event.getTransactionId());
		System.out.println(event.getEvents());
		
	}

}
