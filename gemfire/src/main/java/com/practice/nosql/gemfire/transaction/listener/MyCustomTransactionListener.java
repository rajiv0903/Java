package com.practice.nosql.gemfire.transaction.listener;

import org.apache.geode.cache.TransactionEvent;
import org.apache.geode.cache.util.TransactionListenerAdapter;

public class MyCustomTransactionListener  extends TransactionListenerAdapter{

	@Override
	public void afterCommit(TransactionEvent event) {
		System.out.println(event.getTransactionId());
		System.out.println(event.getEvents());
	}
	
	@Override
	public void afterRollback(TransactionEvent event) {
		System.out.println(event.getTransactionId());
		System.out.println(event.getEvents());
	}
	
	@Override
	public void afterFailedCommit(TransactionEvent event) {
		System.out.println(event.getTransactionId());
		System.out.println(event.getEvents());
	}
	
	
}
