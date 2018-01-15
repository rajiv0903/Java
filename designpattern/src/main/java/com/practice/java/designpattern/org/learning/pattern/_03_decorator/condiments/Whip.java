package com.practice.java.designpattern.org.learning.pattern._03_decorator.condiments;

import com.practice.java.designpattern.org.learning.pattern._03_decorator.beverage.Beverage;
import com.practice.java.designpattern.org.learning.pattern._03_decorator.condiment.CondimentDecorator;
 
public class Whip extends CondimentDecorator {
	Beverage beverage;
 
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
 
	public double cost() {
		return .10 + beverage.cost();
	}
}
