package com.practice.java.designpattern.org.learning.pattern.adapter.entry;

import com.practice.java.designpattern.org.learning.pattern.adapter.adaptee.Turkey;
import com.practice.java.designpattern.org.learning.pattern.adapter.adapter.DuckAdapter;
import com.practice.java.designpattern.org.learning.pattern.adapter.target.MallardDuck;

public class TurkeyTestDrive {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();
		Turkey duckAdapter = new DuckAdapter(duck);
 
		for(int i=0;i<10;i++) {
			System.out.println("The DuckAdapter says...");
			duckAdapter.gobble();
			duckAdapter.fly();
		}
	}
}
