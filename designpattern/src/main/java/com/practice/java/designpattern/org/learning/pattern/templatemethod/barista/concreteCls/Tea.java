package com.practice.java.designpattern.org.learning.pattern.templatemethod.barista.concreteCls;

import com.practice.java.designpattern.org.learning.pattern.templatemethod.barista.abstractCls.CaffeineBeverage;

public class Tea extends CaffeineBeverage {
	public void brew() {
		System.out.println("Steeping the tea");
	}
	public void addCondiments() {
		System.out.println("Adding Lemon");
	}
}
