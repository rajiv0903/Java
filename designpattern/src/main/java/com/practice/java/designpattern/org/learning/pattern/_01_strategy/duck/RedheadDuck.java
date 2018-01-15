package com.practice.java.designpattern.org.learning.pattern._01_strategy.duck;

import com.practice.java.designpattern.org.learning.pattern._01_strategy.fly.FlyWithWings;
import com.practice.java.designpattern.org.learning.pattern._01_strategy.quark.Quack;

public class RedheadDuck extends Duck{

	public RedheadDuck() {
		quackBehavior = new  Quack();
		flyBehavior = new FlyWithWings();
	}
	
	public void display()
	{
		System.out.println("RedheadDuck: Display");
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
