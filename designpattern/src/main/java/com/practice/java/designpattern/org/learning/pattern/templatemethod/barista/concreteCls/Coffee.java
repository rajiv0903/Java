package com.practice.java.designpattern.org.learning.pattern.templatemethod.barista.concreteCls;

import com.practice.java.designpattern.org.learning.pattern.templatemethod.barista.abstractCls.CaffeineBeverage;

public class Coffee extends CaffeineBeverage {
	public void brew() {
		System.out.println("Dripping Coffee through filter");
	}
	public void addCondiments() {
		System.out.println("Adding Sugar and Milk");
	}
}
