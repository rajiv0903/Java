package com.practice.nosql.gemfire.query;



import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.query.FunctionDomainException;
import org.apache.geode.cache.query.NameResolutionException;
import org.apache.geode.cache.query.Query;
import org.apache.geode.cache.query.QueryInvocationTargetException;
import org.apache.geode.cache.query.QueryService;
import org.apache.geode.cache.query.SelectResults;
import org.apache.geode.cache.query.Struct;
import org.apache.geode.cache.query.TypeMismatchException;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

import com.practice.nosql.gemfire.model.Customer;

public class QueryRunner {

	public static void main(String[] args) throws FunctionDomainException, 
	NameResolutionException, QueryInvocationTargetException, TypeMismatchException{
		
		ClientCache clientCache = new ClientCacheFactory()
				/*.set("name", "ClientWorker")*/
				.setPdxSerializer(new ReflectionBasedAutoSerializer("com.practice.nosql.gemfire.model.Customer"))
				.set("cache-xml-file", "clinet-cache.xml").create();

		/** Simple Query : Parameterized **/
		QueryService queryService = clientCache.getQueryService();
		String queryString = "select * from /Customer where firstName.contains($1)";
		Query query = queryService.newQuery(queryString);	
		Object[] params = {"R"};
		SelectResults<Customer> results = (SelectResults<Customer>)query.execute(params);
		for(Customer c: results) {
			System.out.println(c);
		}
		
		/** Projection Query & Struct  **/
		queryService = clientCache.getQueryService();
		queryString = "select firstName, lastName from /Customer";
		query = queryService.newQuery(queryString);
	    SelectResults<Struct> structResults = (SelectResults<Struct>)query.execute();
	    for(Struct struct: structResults) {
	    	String firstName = (String) struct.get("firstName");
	    	String lastName = (String) struct.get("lastName");
	    	System.out.println(firstName);
	    	System.out.println(lastName);
	    }
	    
	    /** Join Query Does not Work on Partition Region - Need to use Function  **/
	    
	    /** Lower case Query  **/
	    queryService = clientCache.getQueryService();
		queryString = "select * from /Customer where lastName.toLowerCase() = 'chaudhuri'";
		query = queryService.newQuery(queryString);
		results = (SelectResults<Customer>)query.execute();
		for(Customer c: results) {
			System.out.println(c);
		}
		/** Set Query **/
		queryService = clientCache.getQueryService();
		queryString = "select * from /Customer where lastName in set ( 'Chaudhuri', 'Bose')";
		query = queryService.newQuery(queryString);
		results = (SelectResults<Customer>)query.execute();
		for(Customer c: results) {
			System.out.println(c);
		}
		
		/** Query: HashMap Style **/
		queryService = clientCache.getQueryService();
		queryString = "select entry.value from /Customer.entrySet entry where entry.key = 1";
		query = queryService.newQuery(queryString);
		results = (SelectResults<Customer>)query.execute();
		for(Customer c: results) {
			System.out.println(c);
		}
	    
	    
	    

	}

}
