package com.practice.java.designpattern.org.learning.pattern._03_decorator.condiments;

import com.practice.java.designpattern.org.learning.pattern._03_decorator.beverage.Beverage;
import com.practice.java.designpattern.org.learning.pattern._03_decorator.condiment.CondimentDecorator;

public class Mocha extends CondimentDecorator {
	Beverage beverage;
 
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
 
	public double cost() {
		return .20 + beverage.cost();
	}
}
