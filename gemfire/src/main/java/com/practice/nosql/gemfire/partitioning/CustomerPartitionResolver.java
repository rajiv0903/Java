package com.practice.nosql.gemfire.partitioning;

import java.util.Properties;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryOperation;
import org.apache.geode.cache.PartitionResolver;

import com.practice.nosql.gemfire.model.BookOrder;
import com.practice.nosql.gemfire.model.OrderKey;

public class CustomerPartitionResolver implements PartitionResolver<OrderKey, BookOrder>, Declarable {

	@Override
	public void close() {		
	}

	@Override
	public Object getRoutingObject(EntryOperation<OrderKey, BookOrder> opDetails) {
		return opDetails.getKey().getCustomerNumber();
	}

	@Override
	public String getName() {
		return getClass().getSimpleName();
	}
	
	@Override
	public void init(Properties props) {
	}

}
