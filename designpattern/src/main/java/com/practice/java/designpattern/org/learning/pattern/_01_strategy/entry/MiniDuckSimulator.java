package com.practice.java.designpattern.org.learning.pattern._01_strategy.entry;

import com.practice.java.designpattern.org.learning.pattern._01_strategy.duck.Duck;
import com.practice.java.designpattern.org.learning.pattern._01_strategy.duck.MallardDuck;
import com.practice.java.designpattern.org.learning.pattern._01_strategy.duck.RubberDuck;
import com.practice.java.designpattern.org.learning.pattern._01_strategy.fly.FlyRocketPowered;
import com.practice.java.designpattern.org.learning.pattern._01_strategy.quark.Squeak;

public class MiniDuckSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Duck mallard = new MallardDuck();
		mallard.display();
		mallard.swim();
		mallard.performFly();
		mallard.performQuack();
		
		Duck rubber = new RubberDuck();
		rubber.display();
		rubber.swim();
		rubber.performFly();
		rubber.performQuack();
		
		rubber.setQuackBehavior(new Squeak());
		rubber.setFlyBehavior(new FlyRocketPowered());
		
		rubber.performFly();
		rubber.performQuack();
		
		

	}

}
