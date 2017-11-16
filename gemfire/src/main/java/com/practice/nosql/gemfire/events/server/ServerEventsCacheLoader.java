package com.practice.nosql.gemfire.events.server;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;

import com.practice.nosql.gemfire.model.BookMaster;
import com.practice.nosql.gemfire.util.MyCustomPdxSerializer;

public class ServerEventsCacheLoader {

	public static void main(String[] args) {
		
		ClientCache cache = 
				new ClientCacheFactory()
				.setPdxSerializer(MyCustomPdxSerializer.getReflectionBasedAutoSerializer())
				.set("cache-xml-file", "clinet-cache.xml").create();
		
		Region<Integer, BookMaster> books = cache.getRegion("BookMaster");
		
		BookMaster book = books.get(1);
		
		if(book != null)
			System.out.println(book);
		else
			System.out.println("No Book for ID 1");
	}
}
