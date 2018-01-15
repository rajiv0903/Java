package com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzafactrory;

import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.ChicagoStyleCheesePizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.ChicagoStyleClamPizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.ChicagoStylePepperoniPizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.ChicagoStyleVeggiePizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzas.Pizza;
import com.practice.java.designpattern.org.learning.pattern._04_factory.factorymethod.pizzastore.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore {

	public Pizza createPizza(String item) {
        	if (item.equals("cheese")) {
            		return new ChicagoStyleCheesePizza();
        	} else if (item.equals("veggie")) {
        	    	return new ChicagoStyleVeggiePizza();
        	} else if (item.equals("clam")) {
        	    	return new ChicagoStyleClamPizza();
        	} else if (item.equals("pepperoni")) {
            		return new ChicagoStylePepperoniPizza();
        	} else return null;
	}
}
