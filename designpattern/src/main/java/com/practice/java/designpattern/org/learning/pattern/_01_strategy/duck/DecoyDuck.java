package com.practice.java.designpattern.org.learning.pattern._01_strategy.duck;

import com.practice.java.designpattern.org.learning.pattern._01_strategy.fly.FlyWithWings;
import com.practice.java.designpattern.org.learning.pattern._01_strategy.quark.Quack;

public class DecoyDuck extends Duck{

	public DecoyDuck() {
		quackBehavior = new  Quack();
		flyBehavior = new FlyWithWings();
	}
	
	public void display()
	{
		System.out.println("DecoyDuck: Display");
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
