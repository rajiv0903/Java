package com.practice.nosql.gemfire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;
import org.junit.Before;
import org.junit.Test;

import com.practice.nosql.gemfire.model.Customer;

public class ClientCacheTests {

	
	private ClientCache clientCache;
	private Region<Integer, Customer> customers;

	@Before
	public void setUp() throws Exception {

		this.clientCache = new ClientCacheFactory()
				.set("name", "ClientWorker")
				.setPdxSerializer(new ReflectionBasedAutoSerializer("com.practice.nosql.gemfire.model.Customer"))
				.set("cache-xml-file", "clinet-cache.xml").create();

		customers = clientCache.getRegion("Customer");

		assertNotNull("Failed to fetch Customer Region", customers);
	}
	
	@Test
	public void testFetchFromProxyRegions() {
		Customer customer = customers.get(1);
		assertNotNull("Customer Should not be null", customer);
		assertEquals("Failed to fetch correct customer object", "Rajiv", customer.getFirstName());
	}

}
