package com.practice.nosql.gemfire.transaction;

import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.CacheTransactionManager;
import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.CommitConflictException;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.TimeoutException;
import org.apache.geode.cache.TransactionDataRebalancedException;
import org.apache.geode.cache.TransactionException;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;

import com.practice.nosql.gemfire.modelpdx.Customer;

public class SimpleTransactionExample {

	private CacheTransactionManager cacheTransactionManager;
	private ClientCache clientCache;
	private Region<Integer, Customer> customers;

	public static void main(String[] args) {

		SimpleTransactionExample loader = new SimpleTransactionExample();

		/*
		 * loader.getCache(); loader.removeAll(); loader.loadCustomers();
		 * loader.closeCache();
		 */

		try {
			loader.getCache();
			loader.begintTransaction();
			loader.changeData();
			loader.commitTransaction();
			loader.closeCache();
		}
		/*
		 * catch (CacheLoaderException | TimeoutException | CacheWriterException |
		 * CommitConflictException | TransactionException e) {
		 */
		catch (CacheLoaderException | TimeoutException | CacheWriterException | TransactionException e) {
			if(e instanceof TransactionDataRebalancedException) {
				//wait and try
			}else {
				loader.rollBackTransaction();
				loader.closeCache();
				throw e;
			}
		}

	}

	private void changeData() {
		Customer customer = customers.get(1);
		customer.getNickNames().add("Raj");
		customers.put(1, customer);

	}

	private void removeAll() {
		customers.removeAll(customers.keySetOnServer());
	}

	private void getCache() {
		this.clientCache = new ClientCacheFactory().set("cache-xml-file", "clinet-transaction.xml").create();
		this.customers = clientCache.getRegion("Customer");
	}

	private void closeCache() {
		clientCache.close();
	}

	private void begintTransaction() {
		this.cacheTransactionManager = clientCache.getCacheTransactionManager();
		cacheTransactionManager.begin();
	}

	private void commitTransaction() {
		cacheTransactionManager.commit();
	}

	private void rollBackTransaction() {
		cacheTransactionManager.rollback();
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

}
