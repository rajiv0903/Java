package com.practice.java.designpattern.org.learning.pattern._04_factory.simplefactory.entry;

import com.practice.java.designpattern.org.learning.pattern._04_factory.simplefactory.pizzaStore.PizzaStore;
import com.practice.java.designpattern.org.learning.pattern._04_factory.simplefactory.pizzafactory.SimplePizzaFactory;
import com.practice.java.designpattern.org.learning.pattern._04_factory.simplefactory.pizzas.Pizza;

public class PizzaTestDrive {
 
	public static void main(String[] args) {
		SimplePizzaFactory factory = new SimplePizzaFactory();
		PizzaStore store = new PizzaStore(factory);

		Pizza pizza = store.orderPizza("cheese");
		System.out.println("We ordered a " + pizza.getName() + "\n");
 
		pizza = store.orderPizza("veggie");
		System.out.println("We ordered a " + pizza.getName() + "\n");
	}
}
