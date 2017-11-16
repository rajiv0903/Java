package com.practice.nosql.gemfire.expiry;

import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.query.FunctionDomainException;
import org.apache.geode.cache.query.NameResolutionException;
import org.apache.geode.cache.query.Query;
import org.apache.geode.cache.query.QueryInvocationTargetException;
import org.apache.geode.cache.query.QueryService;
import org.apache.geode.cache.query.SelectResults;
import org.apache.geode.cache.query.TypeMismatchException;

import com.practice.nosql.gemfire.model.Customer;
import com.practice.nosql.gemfire.util.MyCustomPdxSerializer;

public class MonitorExpiration {

	public static void main(String args[]) throws NameResolutionException, TypeMismatchException,
			FunctionDomainException, QueryInvocationTargetException {

		ClientCache clientCache = new ClientCacheFactory()
				.setPdxSerializer(MyCustomPdxSerializer.getReflectionBasedAutoSerializer())
				.set("cache-xml-file", "clinet-cache.xml").create();

		Region<Integer, Customer> customers = clientCache.getRegion("Customer");

		SelectResults<Customer> results = customers.query("firstName.contains('a')");
		results.forEach(System.out::println);
		
		QueryService queryService = clientCache.getQueryService();
		Query query = queryService.newQuery("select * from /Customer");
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("Checking customer values..");
				try {
					Collection<Customer> customerCollection = 
							(Collection<Customer>) query.execute();
					for (Customer c: customerCollection)
					{
						System.out.println(c);
					}
				}catch (Exception ex) {}
			}
		}, 30, 3000);
		
	}
}
