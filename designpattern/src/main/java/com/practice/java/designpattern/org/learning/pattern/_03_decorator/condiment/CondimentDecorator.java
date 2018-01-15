package com.practice.java.designpattern.org.learning.pattern._03_decorator.condiment;

import com.practice.java.designpattern.org.learning.pattern._03_decorator.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
	public abstract String getDescription();
}
