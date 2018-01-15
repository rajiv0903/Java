package com.practice.java.designpattern.org.learning.pattern._01_strategy.duck;

import com.practice.java.designpattern.org.learning.pattern._01_strategy.fly.FlyNoWay;
import com.practice.java.designpattern.org.learning.pattern._01_strategy.quark.Quack;

public class RubberDuck extends Duck{

	public RubberDuck() {
		quackBehavior = new  Quack();
		flyBehavior = new FlyNoWay();
	}
	
	public void display()
	{
		System.out.println("RubberDuck: Display");
	}
	public void performQuack()
	{
		quackBehavior.quark();
	}
	public void  performFly()
	{
		flyBehavior.fly();
	}

}
