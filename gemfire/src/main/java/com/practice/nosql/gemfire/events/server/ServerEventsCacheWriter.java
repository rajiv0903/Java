package com.practice.nosql.gemfire.events.server;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ServerOperationException;

import com.practice.nosql.gemfire.model.BookMaster;
import com.practice.nosql.gemfire.util.MyCustomPdxSerializer;

public class ServerEventsCacheWriter {
	
	public static void main(String[] args) {
		
		ClientCache cache = 
				new ClientCacheFactory()
				.setPdxSerializer(MyCustomPdxSerializer.getReflectionBasedAutoSerializer())
				.set("cache-xml-file", "clinet-cache.xml").create();
		
		Region<Integer, BookMaster> books = cache.getRegion("BookMaster");
		
		BookMaster book = new BookMaster(4, "Title", "Description", 10.0f, 1984, "R. Chaudhuri");
		
		try {
			books.put(book.getItemNumber(), book);
		}
		catch(ServerOperationException exe) {
			exe.printStackTrace();
		}
		
	}

}
