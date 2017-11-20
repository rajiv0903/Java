package com.practice.nosql.gemfire.serialization;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.query.Query;
import org.apache.geode.cache.query.QueryService;
import org.apache.geode.cache.query.SelectResults;
import org.apache.geode.pdx.PdxInstance;

import com.practice.nosql.gemfire.modelpdx.Customer;
import com.practice.nosql.gemfire.modelpdx.CustomerPdx;

public class SerializationDataLoader {

	private ClientCache cache;
	private ClientCache cachePdx;
	Region<Integer, Customer> customers;
	Region<Integer, CustomerPdx> customersPdx;

	public static void main(String[] args) {

		SerializationDataLoader loader = new SerializationDataLoader();
		loader.getCache();
		loader.removeAll();
		loader.loadCustomers();
		//loader.loadCustomersPdx();
		loader.testFetchByQuery();
		//loader.testFetchByQueryPdx();
		loader.closeCache();

	}

	private void removeAll() {
		customers.removeAll(customers.keySetOnServer());
		//customersPdx.removeAll(customersPdx.keySetOnServer());
	}

	private void getCache() {
		this.cache = new ClientCacheFactory().set("cache-xml-file", "clinet-serialization.xml").create();
		this.customers = cache.getRegion("Customer");
		
		/*this.cachePdx = new ClientCacheFactory().set("cache-xml-file", "clinet-serialization-pdx.xml").create();
		this.customersPdx = cache.getRegion("CustomerPdx");*/
	}

	private void closeCache() {
		cache.close();
		//cachePdx.close();
	}

	private void loadCustomers() {

		System.out.println("Got the customer Region: " + customers);
		Customer cust1 = new Customer(1, "Rajiv", "Chaudhuri", "" + 12345);
		cust1.addOrder(11);
		customers.put(cust1.getCustomerNumber(), cust1);
		System.out.println("Inserted a Customer: " + cust1);

		Customer cust2 = new Customer(2, "Mahika", "Chaudhuri", "" + 12345);
		customers.put(cust2.getCustomerNumber(), cust2);
		System.out.println("Inserted a Customer: " + cust2);

		Customer cust3 = new Customer(3, "Tithi", "Bose", "" + 12345);
		cust3.addOrder(13);
		customers.put(cust3.getCustomerNumber(), cust3);
		System.out.println("Inserted a Customer: " + cust3);

	}

	private void loadCustomersPdx() {

		System.out.println("Got the customer Region: " + customers);
		CustomerPdx cust1 = new CustomerPdx(1, "Rajiv", "Chaudhuri", "" + 12345);
		cust1.addOrder(11);
		customersPdx.put(cust1.getCustomerNumber(), cust1);
		System.out.println("Inserted a CustomerPdx: " + cust1);

		CustomerPdx cust2 = new CustomerPdx(2, "Mahika", "Chaudhuri", "" + 12345);
		customersPdx.put(cust2.getCustomerNumber(), cust2);
		System.out.println("Inserted a CustomerPdx: " + cust2);

		CustomerPdx cust3 = new CustomerPdx(3, "Tithi", "Bose", "" + 12345);
		cust3.addOrder(13);
		customersPdx.put(cust3.getCustomerNumber(), cust3);
		System.out.println("Inserted a CustomerPdx: " + cust3);

	}

	private void testFetchByQuery() {

		QueryService queryService = cache.getQueryService(cache.getDefaultPool().getName());
		Object[] params = { "12345" };
		Query query = queryService.newQuery("select * from /Customer where primaryAddress.postalCode = $1");
		try {
			SelectResults<Customer> results = (SelectResults<Customer>) query.execute(params);
			for (Customer r : results) {
				System.out.println(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}
	}

	private void testFetchByQueryPdx() {

		QueryService queryService = cache.getQueryService(cache.getDefaultPool().getName());
		Object[] params = { "12345" };
		Query query = queryService.newQuery("select * from /Customer where primaryAddress.postalCode = $1");
		try {
			SelectResults<PdxInstance> results = (SelectResults<PdxInstance>) query.execute(params);
			for (PdxInstance pdxInstance : results) {
				
				System.out.println(pdxInstance.getField("customerNumber"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}
	}
}
