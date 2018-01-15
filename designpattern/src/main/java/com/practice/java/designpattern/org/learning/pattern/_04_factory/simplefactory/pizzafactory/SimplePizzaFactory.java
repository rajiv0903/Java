package com.practice.java.designpattern.org.learning.pattern._04_factory.simplefactory.pizzafactory;

import com.practice.java.designpattern.org.learning.pattern._04_factory.simplefactory.pizzas.CheesePizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.simplefactory.pizzas.ClamPizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.simplefactory.pizzas.PepperoniPizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.simplefactory.pizzas.Pizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.simplefactory.pizzas.VeggiePizza;

public class SimplePizzaFactory {

	public Pizza createPizza(String type) {
		Pizza pizza = null;

		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		} else if (type.equals("clam")) {
			pizza = new ClamPizza();
		} else if (type.equals("veggie")) {
			pizza = new VeggiePizza();
		}
		return pizza;
	}
}
