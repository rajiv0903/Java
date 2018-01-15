package com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.entry;

import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.pizzas.Pizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.pizzastore.ChicagoPizzaStore;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.pizzastore.NYPizzaStore;
import com.practice.java.designpattern.org.learning.pattern._04_factory.abstractfactory.pizzastore.PizzaStore;

public class PizzaTestDrive {
 
	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();
 
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("clam");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("clam");
		System.out.println("Joel ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("pepperoni");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("pepperoni");
		System.out.println("Joel ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("veggie");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("veggie");
		System.out.println("Joel ordered a " + pizza + "\n");
	}
}
