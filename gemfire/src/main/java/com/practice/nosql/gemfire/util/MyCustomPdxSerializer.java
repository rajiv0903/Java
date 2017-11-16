package com.practice.nosql.gemfire.util;

import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

public class MyCustomPdxSerializer {

	
	public static ReflectionBasedAutoSerializer getReflectionBasedAutoSerializer() {
		return new ReflectionBasedAutoSerializer(
				"com.practice.nosql.gemfire.model.Customer", 
				"com.practice.nosql.gemfire.model.BookOrder",
				"com.practice.nosql.gemfire.model.BookOrderItem",
				"com.practice.nosql.gemfire.model.OrderKey",
				"com.practice.nosql.gemfire.model.BookMaster"
				);
	}
}
