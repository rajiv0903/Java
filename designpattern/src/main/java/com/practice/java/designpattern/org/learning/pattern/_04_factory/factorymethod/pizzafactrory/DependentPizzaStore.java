package com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzafactrory;

import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.ChicagoStyleCheesePizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.ChicagoStyleClamPizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.ChicagoStylePepperoniPizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.ChicagoStyleVeggiePizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.NYStyleCheesePizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.NYStyleClamPizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.NYStylePepperoniPizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.NYStyleVeggiePizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.Pizza;


public class DependentPizzaStore {
 
	public Pizza createPizza(String style, String type) {
		Pizza pizza = null;
		if (style.equals("NY")) {
			if (type.equals("cheese")) {
				pizza = new NYStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new NYStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new NYStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new NYStylePepperoniPizza();
			}
		} else if (style.equals("Chicago")) {
			if (type.equals("cheese")) {
				pizza = new ChicagoStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new ChicagoStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new ChicagoStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new ChicagoStylePepperoniPizza();
			}
		} else {
			System.out.println("Error: invalid type of pizza");
			return null;
		}
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
