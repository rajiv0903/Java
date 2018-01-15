package com.practice.java.designpattern.org.learning.pattern._03_decorator.beverages;

import com.practice.java.designpattern.org.learning.pattern._03_decorator.beverage.Beverage;

public class Decaf extends Beverage {
	public Decaf() {
		description = "Decaf Coffee";
	}
 
	public double cost() {
		return 1.05;
	}
}

