package com.practice.nosql.gemfire.expiry;

import org.apache.geode.cache.CustomExpiry;
import org.apache.geode.cache.ExpirationAction;
import org.apache.geode.cache.ExpirationAttributes;
import org.apache.geode.cache.Region;

import com.practice.nosql.gemfire.model.Customer;

public class MyCustomExpiry implements CustomExpiry <Integer, Customer>{

	@Override
	public void close() {
		
	}

	@Override
	public ExpirationAttributes getExpiry(Region.Entry<Integer, Customer> entry) {
		if(entry.getKey().equals("alpha")) {
			return new ExpirationAttributes(15, ExpirationAction.INVALIDATE);
		}
		if(entry.getKey().equals("beta")) {
			return new ExpirationAttributes(3, ExpirationAction.DESTROY);
		}
		return null;
	}

}
